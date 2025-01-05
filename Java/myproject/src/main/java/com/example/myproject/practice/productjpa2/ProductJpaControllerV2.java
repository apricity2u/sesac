package com.example.myproject.practice.productjpa2;

import com.example.myproject.practice.productjpa2.dto.ProductCreateRequestDto;
import com.example.myproject.practice.productjpa2.dto.ProductListResponseDto;
import com.example.myproject.practice.productjpa2.dto.ProductResponseDto;
import com.example.myproject.practice.productjpa2.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa/v2/products")
public class ProductJpaControllerV2 {

    private final ProductJpaServiceV2 productJpaServiceV2;

    // Create
    // URL, method(POST), data
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductCreateRequestDto newProduct){
        return productJpaServiceV2.createProduct(newProduct);
    }

    // Read / 전체
    // URL, method(GET)
    @GetMapping
    public List<ProductListResponseDto> getProducts() {
        return productJpaServiceV2.getProducts();
    }

    // Read / 단일
    // URL, method(GET), id
    @GetMapping
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productJpaServiceV2.getProductById(id);
    }

    // Update
    // URL, method(PUT), id, data
    @PutMapping
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto updatedProduct){
        return productJpaServiceV2.updateProduct(id, updatedProduct);
    }


}
