package com.example.myproject.practice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {

    // DB 역할을 해줄 ProductList 만들기
    private List<Product> products = new ArrayList<>();
    private Long id = 0L;

    // 초기화 블럭
    {
        products.add(new Product(++id, "기본 상품", 1000));
    }

    // CRUD 만들기

    // 1. CREATE
    // product, url
    // Restful API : "/products" // method : POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product newProduct){

        String name = newProduct.getName();
        Integer price = newProduct.getPrice();

        if (name == null || name.isBlank()){
            throw new RuntimeException("name을 입력해주세요.");
        }

        if (price == null || price == 0){
            throw new IllegalArgumentException("price를 입력해주세요.");
        }

        Product product = new Product(++id, name, price);
        products.add(product);

        return product;
    }

    // 2. READ
    // 2-1. 전체 조회
    // posts / url
    @GetMapping
    public List<Product> getProducts(){
        return products;
    }

    // 2-2. 단일 조회
    // post / id / url
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        for (Product product : products) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    // 3. UPDATE
    // 변경할 내용 / id / url
    // Restful API : "/products/{id}" // method : PUT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){

        String updatedProductName = updatedProduct.getName();
        Integer updatedProductPrice = updatedProduct.getPrice();

        for (Product product : products) {
            if (product.getId().equals(id)){
                product.setName(updatedProductName);
                product.setPrice(updatedProductPrice);
                return product;
            }
        }
        return null;
    }

    // 4. DELETE
    // id / url
    // Restful API : "/products/{id}" // method : DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product deleteProduct(@PathVariable Long id){
        Product removedProduct = null;

        for (Product product : products) {
            if (product.getId().equals(id)){
                removedProduct = product;
                break;
            }
        }

        products.remove(removedProduct);
        return null;
    }

    @GetMapping("/paged")
    public List<Product> getPaged(@RequestParam int page, @RequestParam int size){
        // 1. 페이지네이션을 위한 더미데이터 추가
        for (int i = 1; i <= 20; i++) {
            String name = "상품 " + i;
            Integer price = 1000 + i;
            Product product = new Product(++id, name, price);
            products.add(product);
        }

        // 2. 시작 인덱스와 끝 인덱스 계산
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, products.size());

        // 3. 페이지에 해당하는 데이터만 추출
        return products.subList(startIndex, endIndex);
    }

}
