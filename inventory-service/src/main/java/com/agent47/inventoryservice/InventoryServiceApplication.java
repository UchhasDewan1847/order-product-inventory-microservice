package com.agent47.inventoryservice;

import com.agent47.inventoryservice.model.Inventory;
import com.agent47.inventoryservice.repository.InventoryRespository;
import com.agent47.inventoryservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRespository inventoryRespository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(50);
			inventory.setSkuCode("iphone_13_pro");
			inventoryRespository.save(inventory);
			inventory.setQuantity(0);
			inventory.setSkuCode("iphone_13_pro_max");
			inventoryRespository.save(inventory);
		};
	}

}
