package com.sparta.crudtest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;

}
