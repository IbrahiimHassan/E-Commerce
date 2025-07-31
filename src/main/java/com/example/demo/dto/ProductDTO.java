package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private int productId;
    private String name;
    private BigDecimal price;
}
