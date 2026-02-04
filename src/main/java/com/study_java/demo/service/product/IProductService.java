package com.study_java.demo.service.product;

import com.study_java.demo.dto.ProductDTO;
import com.study_java.demo.models.Product;
import com.study_java.demo.request.AddProductRequest;
import com.study_java.demo.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDTO> getConvertedProducts(List<Product> products);

    ProductDTO convertToDto(Product product);
}
