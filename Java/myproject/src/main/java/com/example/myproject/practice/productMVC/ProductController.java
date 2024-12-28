package com.example.myproject.practice.productMVC;

import com.example.myproject.practice.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvc/products")
public class ProductController {

    ProductService productService = new ProductService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // client에게 요청을 받는다.
    public Product createProduct(Product newProduct){
        // Service에게 입력받은 데이터를 전달한다.
        return productService.createProduct(newProduct);
    }

    @GetMapping
    public List<Product> readProducts(){
        return productService.readProducts();
    }






}
