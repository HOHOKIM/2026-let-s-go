package com.sparta.crudtest.controller;

import com.sparta.crudtest.entity.Product;
import org.springframework.ui.Model;
import com.sparta.crudtest.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller

public class Controller {
    private final ProductRepository  repository;

    public Controller(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/product-list")
    public String products(Model model) {
        model.addAttribute("products", repository.findAll());
        return "product-list"; //이동
    }

    @GetMapping("/product-new")
    public String productNew(){
       return "product-new"; //이동
    }

    @PostMapping("/products")
    public String createProduct(Product product){
        repository.save(product); //저장
    return "redirect:/product-list";
    }

   @PostMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable Integer id) {
       repository.deleteById(id);
       return "redirect:/product-list";//삭제
   }

   @GetMapping("/products/{id}/update")
    public String updateProduct(@PathVariable Integer id,Model model) {
        Product product =repository.findById(id).orElseThrow();
        model.addAttribute("product",product);
        return "product-update"; //수정폼 열기
    }
    @PostMapping("/products/{id}/update")
    public String outUpdate(@PathVariable Integer id, @ModelAttribute Product product){
        product.setId(id);
        repository.save(product);
        return "redirect:/product-list"; //수정후 이동
    }


}
