package com.sparta.crudtest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductRequestDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;

}
