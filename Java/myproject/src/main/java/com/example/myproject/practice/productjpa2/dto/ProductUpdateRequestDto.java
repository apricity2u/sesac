package com.example.myproject.practice.productjpa2.dto;

import com.example.myproject.practice.productjpa2.ProductJpaV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ProductUpdateRequestDto {

    private String name;
    private Integer price;

}
