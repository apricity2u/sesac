package com.example.myproject.practice.productjpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 전용 트랜잭션
public class ProductServiceJpa {

    private final ProductRepositoryJpa productRepository;

    @Transactional // 쓰기도 가능한 트랜잭션 (좁은 범위의 것을 더 먼저 실행)
    public ProductJpa createProduct(ProductJpa newProduct){
        // 여기에 validation 체크를 넣으면 좋을 것 같음
        return productRepository.save(newProduct);
    }

    public ProductJpa getProductById(Long id){
        return productRepository.findById(id);
    }

    public List<ProductJpa> getProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public ProductJpa updateProduct(Long id, ProductJpa updatedProduct){
        return productRepository.update(id, updatedProduct);
    }

    @Transactional
    public void deleteProduct(Long id){
        productRepository.delete(id);
    }

}
