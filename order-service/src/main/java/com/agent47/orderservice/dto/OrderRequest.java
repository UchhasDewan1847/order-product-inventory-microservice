package com.agent47.orderservice.dto;


import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
    @OneToMany
    private List<OrderLineItemsDto> orderLineItemsDtos;
}
