package com.sparta.crudtest.controller;
import com.sparta.crudtest.entity.Order;
import com.sparta.crudtest.entity.Product;
import com.sparta.crudtest.repository.ProductRepository;
import com.sparta.crudtest.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/orders")
public class OrderController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/{id}")
    public String saveOrder(@PathVariable Integer id) {
        // Product 조회
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품 없음"));

        // Product 정보를 그대로 Order에 복사
        Order order = new Order();
        order.setId(product.getId());
        order.setName(product.getName());
        order.setDescription(product.getDescription());
        order.setPrice(product.getPrice());
        order.setStock(product.getStock());

        // Orders 테이블에 저장
        orderRepository.save(order);

        // 저장 후 다시 상품 목록으로 이동
        return "redirect:/products";
    }
}