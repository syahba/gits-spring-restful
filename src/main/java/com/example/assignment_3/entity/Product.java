package com.example.assignment_3.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
  @JsonProperty("nama")
  private String name;

  @Column(name = "modal")
  @JsonProperty("hargaBeli")
  private int modal;

  @Column(name = "price")
  @JsonProperty("hargaJual")
  private int price;

  // constructor
  public Product() {}

  public Product(String name, int modal, int price) {
    this.name = name;
    this.modal = modal;
    this.price = price;
  }

  // getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getModal() {
    return this.modal;
  }

  public void setModal(int modal) {
    this.modal = modal;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
