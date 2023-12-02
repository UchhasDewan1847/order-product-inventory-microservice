package com.agent47.inventoryservice;

import com.agent47.inventoryservice.model.Inventory;
import com.agent47.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
//			Inventory inventory = new Inventory();
//			inventory.setQuantity(50);
//			inventory.setSkuCode("iphone_13_pro");
//			inventoryRepository.save(inventory);
//			inventory.setQuantity(0);
//			inventory.setSkuCode("iphone_13_pro_max");
//			inventoryRepository.save(inventory);
		};
	}

}
