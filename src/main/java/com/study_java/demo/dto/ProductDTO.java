package com.study_java.demo.dto;

import com.study_java.demo.models.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
    private  Long id;
    private  String name;
    private  String description;
    private BigDecimal price;
    private  int inventory;
    private  String brand;
    private Category category;
    private List<ImageDTO> images;
}
