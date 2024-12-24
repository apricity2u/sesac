package org.example;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Payable {

    // 상품을 여러 개 가지고 있다.
    // Map 사용
    private Map<String, Product> products;
    private User user;

    public VendingMachine() {
        this.products = new HashMap<String, Product>();
        this.user = null;

        System.out.println("Vending Machine is available.");
    }

    // getter
    public Map<String, Product> getProducts() {
        return products;
    }

    public void startButton(User user){
        this.user = user;
        System.out.println("What do you want to buy?");
    }

    // 상품 결제
    @Override
    public void pay() {

    }
}
