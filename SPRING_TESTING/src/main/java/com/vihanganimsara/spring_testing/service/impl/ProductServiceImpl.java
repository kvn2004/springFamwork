package com.vihanganimsara.spring_testing.service.impl;

import com.vihanganimsara.spring_testing.entity.Product;
import com.vihanganimsara.spring_testing.repository.ProductRepository;
import com.vihanganimsara.spring_testing.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found with id: " + id)
        );
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existProduct = getProductById(product.getId());
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        return productRepository.save(existProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
