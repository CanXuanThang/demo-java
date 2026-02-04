package com.study_java.demo.request;

import com.study_java.demo.models.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {
    private  Long id;
    private  String name;
    private  String description;
    private BigDecimal price;
    private  int inventory;
    private  String brand;
    private Category category;
}
