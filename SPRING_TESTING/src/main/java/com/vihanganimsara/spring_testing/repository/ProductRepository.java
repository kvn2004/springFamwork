package com.vihanganimsara.spring_testing.repository;

import com.vihanganimsara.spring_testing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
