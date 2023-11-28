package com.agent47.inventoryservice.service;

import org.springframework.stereotype.Service;

@Service
public interface InventoryService {
    Boolean isInStock(String skuCode);
}
