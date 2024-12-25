package org.example;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Payable {

    // 상품을 여러 개 가지고 있다. (Map 사용)
    private Map<String, Product> productList;
    // 자판기는 유저 정보를 가지고 있다.
    private User user;

    public VendingMachine() {
        this.productList = new HashMap<String, Product>();
        this.user = null;

        System.out.println("Vending Machine is available.\n");
    }

    // productList의 Getter
    public Map<String, Product> getProductList() {
        return productList;
    }

    // 상품별 디테일 보여주기
    public void getProductDetail() {
        for (String key : productList.keySet()) {
            System.out.println(productList.get(key));
        }
    }

    // 자판기 시작 버튼 누르기
    public void startButton(User user){
        this.user = user;
        System.out.println("Please select what you want.");
        getProductDetail();
        System.out.println();
    }

    // 상품 결제
    @Override
    public void purchaseProduct(String productName, Integer quantity) {

        for (String key : productList.keySet()) {
            if (!key.equals(productName)){
                continue;
            }

            Product product = productList.get(key);

            pay(product, quantity);
            sale(product, quantity);

            System.out.println("You get " + quantity + " " + productName + ".");
            System.out.println("Change : " + user.getMoney() + "\n");

            getProductDetail();
        }

    }

    // 보유금액 - 가격 * 구매 수량
    private void pay(Product product, Integer quantity){
        user.setMoney(user.getMoney() - product.getPrice() * quantity);
    }

    // 재고 - 구매 수량
    private void sale(Product product, Integer quantity){
        product.setStock(product.getStock() - quantity);
    }
}
