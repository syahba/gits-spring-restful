package com.example.assignment_3.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_3.entity.Product;
import com.example.assignment_3.repository.ProductRepository;

@RestController
@RequestMapping("products")

public class ProductController {
  private final Logger logger = LoggerFactory.getLogger(ProductController.class);

  // inject bean
  @Autowired
  ProductRepository productRepository;

  // get product api
  @GetMapping("")
  public List<Product> getProducts() {
    List<Product> products = productRepository.findAll();
    logger.info("get products success");

    return products;
  }

  // create product api
  @PostMapping("")
  public Product createProduct(@RequestBody Product data) {
    logger.info("save product success");
    return productRepository.save(data);
  }

  // delete product api
  @DeleteMapping("{id}")
  public void deleteProduct(@PathVariable Long id) {
    productRepository.deleteById(id);
    logger.info("delete product success");
  }
}
