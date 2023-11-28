package com.agent47.orderservice.controller;

import com.agent47.orderservice.dto.OrderRequest;
import com.agent47.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest ){
        orderService.placeOrder(orderRequest);

        return "Order created Successfully";
    }
}
