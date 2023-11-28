package com.agent47.orderservice.service;

import com.agent47.orderservice.dto.OrderRequest;
import org.springframework.stereotype.Service;

@Service

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
