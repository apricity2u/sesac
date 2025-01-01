package com.example.myproject.practice.productjpa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // BEAN 등록, 요청과 응답
@RequiredArgsConstructor // Service DI 해야해서 생성자를 넣음
@RequestMapping("/jpa/posts") // baseURL
public class ProductControllerJpa {

    private final ProductServiceJpa productServiceJpa;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductJpa createProduct(@RequestBody ProductJpa newProduct){
        return productServiceJpa.createProduct(newProduct);
    }

    @GetMapping
    public ProductJpa getProductById(@PathVariable Long id){
        return productServiceJpa.getProductById(id);
    }

    @GetMapping("/{id}")
    public List<ProductJpa> getProducts(){
        return productServiceJpa.getProducts();
    }

    @PutMapping("/{id}")
    public ProductJpa updateProduct(@PathVariable Long id, @RequestBody ProductJpa updatedProduct){
        return productServiceJpa.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        productServiceJpa.deleteProduct(id);
    }

}
