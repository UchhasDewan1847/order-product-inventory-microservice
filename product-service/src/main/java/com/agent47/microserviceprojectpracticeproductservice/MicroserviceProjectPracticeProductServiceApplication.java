package com.agent47.microserviceprojectpracticeproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProjectPracticeProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProjectPracticeProductServiceApplication.class, args);
	}

}
