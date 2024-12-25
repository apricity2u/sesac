package org.example;

import java.util.Map;

public class Manager {

    private final VendingMachine vendingMachine;

    // 해당 자판기를 관리하는 관리자로 지정
    public Manager(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // 자판기에 상품 추가하기
    public void putProduct(Product product){

        Map<String, Product> products = vendingMachine.productList;
        products.put(product.name, product);
    }

    // 자판기에 재고 추가하기
    public void addStock(String productName, int amount){
        Product product = vendingMachine.productList.get(productName);
        product.setStock(amount);
    }

    // 상품 가격 수정하기
    public void changePrice(String productName, int amount){
        Product product = vendingMachine.productList.get(productName);
        product.setPrice(amount);
    }

    // 매출 확인하기
    public void getRevenue(){

        int revenue = 0;

        for (String key : vendingMachine.salesList.keySet()) {

            int productPrice = vendingMachine.productList.get(key).getPrice();
            int salesVolume = vendingMachine.salesList.get(key);

            revenue += productPrice * salesVolume;
        }

        System.out.println("Revenue: " + revenue);
    }
}
