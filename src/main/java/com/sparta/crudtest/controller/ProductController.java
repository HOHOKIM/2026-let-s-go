package com.sparta.crudtest.controller;

import com.sparta.crudtest.Service.ProductService;
import com.sparta.crudtest.dto.ProductRequestDto;
import com.sparta.crudtest.entity.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller

public class ProductController {
    private final ProductService productService;

    //생성자 주입
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/product-list")
    public String products(Model model) {
        model.addAttribute("products",productService.findAllProducts());
        return "product-list"; //이동
    }
    //상품 생성
    @GetMapping("/product-new")
    public String productNew(){
       return "product-new"; //이동
    }
    
    @PostMapping("/products")
    public String createProduct(@ModelAttribute ProductRequestDto dto){
        productService.saveProduct(dto); //저장
    return "redirect:/product-list";
    }

   @PostMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
       productService.deleteProduct(id);
       return "redirect:/product-list";//삭제
   }
    //상품수정
   @GetMapping("/products/{id}/update")
    public String updateProduct(@PathVariable Long id,Model model) {
        Product product =productService.findProductById(id);
        model.addAttribute("product",product);
        return "product-update"; //수정폼 열기
    }

    @PostMapping("/products/{id}/update")
    public String outUpdate(@PathVariable Long id, @ModelAttribute ProductRequestDto dto) {
        dto.setId(id);
        productService.updateProduct(dto);
        return "redirect:/product-list";
    }

}
