package com.example.myproject.practice.productjpa2;

import com.example.myproject.practice.productjpa2.dto.ProductUpdateRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductJpaV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private String author;

    @Builder
    public ProductJpaV2(String name, Integer price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public ProductJpaV2 update(ProductUpdateRequestDto updateRequestDto){
        this.name = updateRequestDto.getName();
        return this;
    }
}
