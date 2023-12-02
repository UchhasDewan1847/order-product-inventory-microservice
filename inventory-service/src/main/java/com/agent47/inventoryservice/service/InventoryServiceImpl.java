package com.agent47.inventoryservice.service;

import com.agent47.inventoryservice.dto.InventoryResponse;
import com.agent47.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }
}
