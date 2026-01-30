package com.sparta.crudtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private Long id;   // Product의 id를 그대로 사용

    private String name;
    private String description;
    private int price;
    private int stock;

    // getter, setter
}