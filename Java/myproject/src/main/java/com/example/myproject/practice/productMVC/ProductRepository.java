package com.example.myproject.practice.productMVC;

import com.example.myproject.practice.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    // DB 역할을 해줄 ProductList 만들기
    private List<Product> products = new ArrayList<>();
    private Long id = 0L;

    // 데이터베이스와 상호작용하면서
    // 데이터의 CRUD를 담당한다.

    // product를 저장. Create한다!
    public Product save(Product newProduct){
        String name = newProduct.getName();
        Integer price = newProduct.getPrice();

        Product product = new Product(++id, name, price);
        products.add(product);

        return product;
    }

    // products를 조회하자. (전체 조회)
    public List<Product> findAll(){
        return products;
    }


}
