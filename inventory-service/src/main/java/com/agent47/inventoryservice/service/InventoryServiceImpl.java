package com.agent47.inventoryservice.service;

import com.agent47.inventoryservice.repository.InventoryRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRespository inventoryRespository;
    @Override
    public Boolean isInStock(String skuCode) {
        return inventoryRespository.findBySkuCode(skuCode).isPresent();
    }
}
