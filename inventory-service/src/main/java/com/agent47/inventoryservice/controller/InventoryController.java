package com.agent47.inventoryservice.controller;

import com.agent47.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable("skuCode") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
