package com.vihanganimsara.spring_testing;

import com.vihanganimsara.spring_testing.entity.Product;
import com.vihanganimsara.spring_testing.repository.ProductRepository;
import com.vihanganimsara.spring_testing.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceApplicationTest {
    @InjectMocks
    private ProductServiceImpl productServiceimpl;
    @Mock
    private ProductRepository productRepository;
    private Product product;

    @BeforeEach
    public void setup() {
        product = Product.builder()
                .id(1L)
                .name("Product 1")
                .price(100.0)
                .quantity(12)
                .build();
    }

    @Test
    void should_save_product() {
        //Arrange DATA

        when(productRepository.save(any(Product.class))).thenReturn(product);


        //Action
        Product savedproduct = productServiceimpl.createProduct(product);
        //assert
        Assertions.assertNotNull(savedproduct);
        Assertions.assertEquals(product, savedproduct);
        verify(productRepository, times(1)).save(any(Product.class));
    }
}
