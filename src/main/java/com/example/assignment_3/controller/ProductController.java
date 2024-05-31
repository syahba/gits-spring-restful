package com.example.assignment_3.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<Product>> getProducts() {
    List<Product> products = productRepository.findAll();

    logger.info("Get Products Success");
    return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
  }

  // create product api
  @PostMapping("")
  public ResponseEntity<Product> createProduct(@RequestBody Product data) {
    Product product = productRepository.save(data);

    logger.info("Create Product Success");
    return new ResponseEntity<Product>(product, HttpStatus.CREATED);
  }

  // delete product api
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
    // error handling for not found products
    if (!productRepository.existsById(id)) {
      logger.info("Product Doesn't Exist");
      return new ResponseEntity<String>("Data Not Found", HttpStatus.NOT_FOUND);
    }

    productRepository.deleteById(id);

    logger.info("Delete Product Success");
    return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
  }
}
