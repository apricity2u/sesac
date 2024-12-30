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
    public Product createProduct(@RequestBody Product newProduct){
        // Service에게 입력받은 데이터를 전달한다.
        return productService.createProduct(newProduct);
    }

    @GetMapping
    public List<Product> readProducts(){
        return productService.readProducts();
    }

    @GetMapping("/{id}")
    public Product readProductById(@PathVariable Long id) {
        return productService.readProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePRoduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
