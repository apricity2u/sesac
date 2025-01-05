package com.example.myproject.practice.productjpa2.dto;

import com.example.myproject.practice.productjpa2.ProductJpaV2;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductListResponseDto {

    private final Long id;
    private final String name;

    public static ProductListResponseDto from(ProductJpaV2 entity){
        return ProductListResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
