package com.example.myproject.practice.productjpa2;

import com.example.myproject.practice.productjpa2.dto.ProductCreateRequestDto;
import com.example.myproject.practice.productjpa2.dto.ProductListResponseDto;
import com.example.myproject.practice.productjpa2.dto.ProductResponseDto;
import com.example.myproject.practice.productjpa2.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductJpaServiceV2 {

    private final ProductJpaRepositoryV2 productJpaRepositoryV2;

    @Transactional
    public ProductResponseDto createProduct(ProductCreateRequestDto newProduct){
        // RequestDTO => Entity
        // DB에 newProduct를 save
        ProductJpaV2 product = productJpaRepositoryV2.save(newProduct.toEntity());
        // Entity => ResponseDTO
        return ProductResponseDto.from(product);
    }

    public List<ProductListResponseDto> getProducts(){
        // Entity에서 가져온 데이터들을 모두 ResponseDto 형태로 바꿔야 함
        // map을 사용하기 위해서는 stream으로 변환해야 함
        return productJpaRepositoryV2.findAll().stream()
                .map(ProductListResponseDto :: from)
                .toList();
    }

    public ProductResponseDto getProductById(Long id){
        // Entity에서 findById 를 하면 optional이 반환됨.
        // optional은 null에 대한 처리를 유연하게 함.
        ProductJpaV2 product = productJpaRepositoryV2.findById(id)
                .orElseThrow(()->new IllegalArgumentException("없는 id입니다."));

        return ProductResponseDto.from(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductUpdateRequestDto updateRequestDto){
        ProductJpaV2 product = productJpaRepositoryV2.findById(id)
                .orElseThrow(()->new IllegalArgumentException("없는 id입니다."));

        product.update(updateRequestDto);
        return ProductResponseDto.from(product);
    }

}
