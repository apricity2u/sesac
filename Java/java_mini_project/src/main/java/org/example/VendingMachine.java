package org.example;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Payable {

    // 상품을 여러 개 가지고 있다.
    // Map 사용
    private Map<String, Product> products;

    public VendingMachine() {
        this.products = new HashMap<String, Product>();
    }

    // 상품 결제
    @Override
    public void pay() {

    }
}
