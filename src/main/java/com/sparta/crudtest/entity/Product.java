package com.sparta.crudtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor

public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     // Long 으로 바꿨음 변화 확인하기
     private Long id;

     @Column(nullable = false, length = 100)
     private  String name;

     @Column(columnDefinition = "TEXT")
     private  String description;

     @Column(nullable = false)
     private Double price ;

     @Column(nullable = false)
     private int stock ;


}
