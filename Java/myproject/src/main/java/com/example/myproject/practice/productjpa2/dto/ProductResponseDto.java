package com.example.myproject.practice.productjpa2.dto;

import com.example.myproject.practice.productjpa2.ProductJpaV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class ProductResponseDto {

    private final Long id;
    private final String name;
    private final Integer price;
    private final String author;

    public static ProductResponseDto from(ProductJpaV2 entity){
        return ProductResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .author(entity.getAuthor())
                .build();
    }

}
