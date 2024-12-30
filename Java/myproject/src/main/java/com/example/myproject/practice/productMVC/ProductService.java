package com.example.myproject.practice.productMVC;

import com.example.myproject.practice.Product;

import java.util.List;

public class ProductService {

    // product를 만들어야 하니까, save를 호출해야함.
    // ProductRepository를 컴포지션으로 가지고 있어야 함.
    ProductRepository productRepository = new ProductRepository();

    // Controller에게 요청을 받아서
    public Product createProduct(Product newProduct){

        // 비즈니스 로직을 처리하고 (validation check)
        String name = newProduct.getName();
        Integer price = newProduct.getPrice();

        if (name == null || name.isBlank()){
            throw new RuntimeException("name을 입력해주세요.");
        }

        if (price == null || price == 0){
            throw new IllegalArgumentException("price를 입력해주세요.");
        }

        // product를 만든다.
        return productRepository.save(newProduct);
    }

    public List<Product> readProducts(){
        return productRepository.findAll();
    }

    public Product readProductById(Long id){

        Product product = productRepository.findProductById(id);

        // id 유효성 검사하기
        if (product == null){
            throw new IllegalArgumentException("없는 id입니다");
        }

        return productRepository.findProductById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct){

        Product product = productRepository.findProductById(id);

        // id 유효성 검사하기
        if (product == null){
            throw new IllegalArgumentException("없는 id입니다");
        }

        // 비즈니스 로직을 처리하고 (validation check)
        String name = updatedProduct.getName();
        Integer price = updatedProduct.getPrice();

        if (name == null || name.isBlank()){
            throw new RuntimeException("name을 입력해주세요.");
        }

        if (price == null || price == 0){
            throw new IllegalArgumentException("price를 입력해주세요.");
        }

        return productRepository.modify(id, updatedProduct);

    }

    public void deleteProduct(Long id){
        Product product = productRepository.findProductById(id);

        // id 유효성 검사하기
        if (product == null){
            throw new IllegalArgumentException("없는 id입니다");
        }

        productRepository.delete(product);
    }

}
