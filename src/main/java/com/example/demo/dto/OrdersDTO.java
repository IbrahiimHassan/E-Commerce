package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrdersDTO {
    private int orderId;
    private LocalDate orderDate;
    private BigDecimal totalAmount;
    private String status;
}
