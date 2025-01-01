package com.example.myproject.practice.productjpa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJpa {

    private Long id;
    private String name;
    private Integer price;

    public ProductJpa() {
    }

    public ProductJpa(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void update(String name, Integer price){
        this.name = name;
        this.price = price;
    }

}
