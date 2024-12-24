package org.example;

import java.util.Map;

public class Manager {

    private VendingMachine vendingMachine;

    // 해당 자판기를 관리하는 관리자로 지정
    public Manager(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // 자판기에 상품 추가하기
    public void putProduct(Product product){

        Map<String, Product> products = vendingMachine.getProducts();
        products.put(product.getName(), product);

        System.out.println(products);
    }

}
