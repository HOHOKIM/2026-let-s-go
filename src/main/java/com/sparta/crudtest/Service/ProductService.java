package com.sparta.crudtest.Service;

import com.sparta.crudtest.dto.ProductRequestDto;
import com.sparta.crudtest.entity.Product;
import com.sparta.crudtest.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // 생성자 주입
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 등록
    @Transactional
    public void saveProduct(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        productRepository.save(product);
    }

    // 상품 수정
    @Transactional
    public void updateProduct(ProductRequestDto dto) {
        Product product = productRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("상품 없음"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        productRepository.save(product);
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // 상품 단건 조회
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품 없음"));
    }

    // 상품 전체 조회
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}