package com.example.backend_labresultx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_labresultx.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
