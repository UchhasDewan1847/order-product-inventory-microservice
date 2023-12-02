package com.agent47.microserviceprojectpracticeproductservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class MicroserviceProjectPracticeProductServiceApplicationTests {
//	@Container
//	PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
//		dynamicPropertyRegistry.add("spring.cata.postgres.uri",PostgreSQLContainer::getJdbcUrl);
//	}
	// I don't know how it works . I need to focus on this better

	@Test
	void contextLoads() {
	}

}
