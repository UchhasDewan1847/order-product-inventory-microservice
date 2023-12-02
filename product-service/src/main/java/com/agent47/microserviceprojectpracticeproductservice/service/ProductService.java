package com.agent47.microserviceprojectpracticeproductservice.service;

import com.agent47.microserviceprojectpracticeproductservice.dto.ProductRequest;
import com.agent47.microserviceprojectpracticeproductservice.dto.ProductResponse;
import com.agent47.microserviceprojectpracticeproductservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
