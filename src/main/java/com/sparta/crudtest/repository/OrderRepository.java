package com.sparta.crudtest.repository;

import com.sparta.crudtest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}