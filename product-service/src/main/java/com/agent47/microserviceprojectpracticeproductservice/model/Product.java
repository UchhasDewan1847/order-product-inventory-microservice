package com.agent47.microserviceprojectpracticeproductservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import java.math.BigDecimal;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    // In the tutorial the Programming Techie used String as Identifier
    // I don't understand How he did so , Because it is not working for me
    // So I kept the identifier in the Long format
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
