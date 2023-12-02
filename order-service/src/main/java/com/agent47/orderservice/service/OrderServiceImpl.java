package com.agent47.orderservice.service;

import com.agent47.orderservice.dto.InventoryResponse;
import com.agent47.orderservice.dto.OrderLineItemsDto;
import com.agent47.orderservice.dto.OrderRequest;
import com.agent47.orderservice.model.Order;
import com.agent47.orderservice.model.OrderLineItems;
import com.agent47.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private  WebClient.Builder webClientBuilder;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
//        System.out.println(orderRequest);
//        log.info("order request is {}",orderRequest);

        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDTos()
                .stream()
                .map(this::mapToDto)
                .toList());



        List<String> skuCodes =order.getOrderLineItemsList()
                .stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
        //call inventory service and place order if product is in stock
        InventoryResponse[] inventoryResponses =webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes)
                                .build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        Boolean allProductsInStock = Arrays.stream(inventoryResponses)
                .allMatch(InventoryResponse::getIsInStock);

        if (Boolean.TRUE.equals(allProductsInStock)){
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product is not in stock, Please try again later");
        }
    }
    // This is an asynchronous implementation of webclient
//    @Override
//    public void placeOrder(OrderRequest orderRequest)
//
//    {
//        Order order = new Order();
//        order.setOrderNumber(UUID.randomUUID().toString());
//
//        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDTos()
//                .stream()
//                .map(this::mapToDto)
//                .toList());
//
//        List<String> skuCodes = order.getOrderLineItemsList()
//                .stream()
//                .map(OrderLineItems::getSkuCode)
//                .toList();
//
//        // Make asynchronous calls to the inventory service for each SKU code
//        Flux<InventoryResponse> inventoryResponsesFlux = Flux.fromIterable(skuCodes)
//                .flatMap(skuCode -> webClientBuilder.build()
//                        .get()
//                        .uri("http://inventory-service/api/inventory",
//                                uriBuilder -> uriBuilder.queryParam("skuCode", skuCode)
//                                        .build())
//                        .retrieve()
//                        .bodyToMono(InventoryResponse.class));
//
//        // Collect all responses and check if all products are in stock
//        Mono<Boolean> allProductsInStockMono = inventoryResponsesFlux
//                .collectList()
//                .map(inventoryResponses -> Arrays.stream(inventoryResponses)
//                        .allMatch(InventoryResponse::getIsInStock));
//
//        // Save the order if all products are in stock
//        allProductsInStockMono
//                .subscribe(allProductsInStock -> {
//                    if (Boolean.TRUE.equals(allProductsInStock)) {
//                        orderRepository.save(order);
//                    } else {
//                        throw
//
//                                new IllegalArgumentException("Product is not in stock, Please try again later");
//                    }
//                });
//    }

    private OrderLineItems  mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }
}
