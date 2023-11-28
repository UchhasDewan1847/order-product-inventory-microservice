package com.agent47.orderservice.service;

import com.agent47.orderservice.dto.OrderLineItemsDto;
import com.agent47.orderservice.dto.OrderRequest;
import com.agent47.orderservice.model.Order;
import com.agent47.orderservice.model.OrderLineItems;
import com.agent47.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDtos()
                .stream()
                .map(this::mapToDto)
                .toList());
        orderRepository.save(order);
    }

    private OrderLineItems  mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }
}
