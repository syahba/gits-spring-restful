package com.example.assignment_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment_3.entity.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
