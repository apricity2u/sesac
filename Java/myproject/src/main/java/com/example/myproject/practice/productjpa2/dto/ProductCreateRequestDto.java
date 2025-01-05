package com.example.myproject.practice.productjpa2.dto;

import com.example.myproject.practice.productjpa2.ProductJpaV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCreateRequestDto {

    private String name;
    private Integer price;
    private String author;

    @Builder
    public ProductJpaV2 toEntity(){
        return ProductJpaV2.builder()
                .name(this.name)
                .price(this.price)
                .author(this.author)
                .build();
    }

}
