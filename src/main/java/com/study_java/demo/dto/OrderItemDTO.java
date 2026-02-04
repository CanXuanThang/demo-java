package com.study_java.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private int quantity;
}
