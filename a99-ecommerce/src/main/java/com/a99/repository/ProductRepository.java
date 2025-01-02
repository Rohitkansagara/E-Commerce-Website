package com.a99.repository;

import com.a99.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Method to find products by category ID
    List<Product> findByCategoryId(Long categoryId);
}
