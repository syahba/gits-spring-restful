package com.example.assignment_3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Product {
  // identifier
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  // columns
  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private int price;

  @Column(name = "modal")
  private int modal;

  // constructor
  public Product() {}

  public Product(String name, int price, int modal) {
    this.name = name;
    this.price = price;
    this.modal = modal;
  }

  // getters and setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getModal() {
    return this.modal;
  }

  public void setModal(int modal) {
    this.modal = modal;
  }
}
