package com.agent47.microserviceprojectpracticeproductservice.controller;

import com.agent47.microserviceprojectpracticeproductservice.dto.ProductRequest;
import com.agent47.microserviceprojectpracticeproductservice.dto.ProductResponse;
import com.agent47.microserviceprojectpracticeproductservice.model.Product;
import com.agent47.microserviceprojectpracticeproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
