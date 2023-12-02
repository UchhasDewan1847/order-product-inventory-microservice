package com.agent47.inventoryservice.service;

import com.agent47.inventoryservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
