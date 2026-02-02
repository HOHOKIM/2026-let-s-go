package com.sparta.crudtest.controller;

import com.sparta.crudtest.entity.Order;
import com.sparta.crudtest.entity.Product;
import com.sparta.crudtest.repository.OrderRepository;
import com.sparta.crudtest.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(ProductRepository productRepository,
                           OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders/{id}")
    // 아이디 오류 생겨서 Long 에서 Integer로 바뀐거 생각하기
    public String createOrder(@PathVariable Integer id, Model model) {
        // 상품 조회
        Product product = productRepository.findById(id).orElseThrow();
        // 주문 객체 생성
        Order order = new Order();
        order.setProductId(Long.valueOf(product.getId()));
        order.setName(product.getName());
        order.setPrice(product.getPrice());
        order.setStock(product.getStock());
        order.setDescription(product.getDescription());

        orderRepository.save(order);

        return "redirect:/product-list"; // 저장 후 메인으로 이동 (원하면 /orders로 바꿀 수 있음)
        }
        // 주문 페이지로 이동
        //복습하기 컨트롤러에서 매핑이름 정하기 -> 그다음 템플릿에서 겟팅(매핑)해서 연결하기
        @GetMapping("/product-order")
        public String  orderList(Model model){
        model.addAttribute("orders",orderRepository.findAll());
                return "product-order";
        }

    @PostMapping("orders/{id}/delete")
    public String deleteOrder(@PathVariable Integer id) {
        orderRepository.deleteById(Long.valueOf(id));
        return "redirect:/product-order";
    }
            

}