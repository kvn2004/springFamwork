package com.vihanganimsara.spring_testing.service;

import com.vihanganimsara.spring_testing.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);

}
