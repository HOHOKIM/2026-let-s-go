package com.sparta.crudtest.repository;
import com.sparta.crudtest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}