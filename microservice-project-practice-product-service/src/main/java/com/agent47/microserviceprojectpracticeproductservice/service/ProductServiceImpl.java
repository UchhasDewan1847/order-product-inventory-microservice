package com.agent47.microserviceprojectpracticeproductservice.service;

import com.agent47.microserviceprojectpracticeproductservice.dto.ProductRequest;
import com.agent47.microserviceprojectpracticeproductservice.dto.ProductResponse;
import com.agent47.microserviceprojectpracticeproductservice.model.Product;
import com.agent47.microserviceprojectpracticeproductservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .name(productRequest.getName())
                .build();
        productRepository.save(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        // Alternate way
//        List<ProductResponse> productResponses = new ArrayList<>();
//        for (Product product:products)
//        {
//            productResponses.add(ProductResponse.builder()
//                    .id(product.getId())
//                    .name(product.getName())
//                    .description(product.getDescription())
//                    .price(product.getPrice()).build());
//        }
//        return productResponses;
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
