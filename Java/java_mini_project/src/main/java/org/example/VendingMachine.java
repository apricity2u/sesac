package org.example;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Payable {

    // 상품을 여러 개 가지고 있다. (Map 사용)
    private Map<String, Product> productList;
    // 자판기는 유저 정보를 가지고 있다.
    private User user;
    // 자판기 작동중
    private boolean isRunning;

    public VendingMachine() {
        this.productList = new HashMap<String, Product>();
        this.user = null;
        this.isRunning = false;
    }

    // productList의 Getter
    public Map<String, Product> getProductList() {
        return productList;
    }

    // 상품별 디테일 보여주기
    public void getProductDetail() {
        System.out.println("<Products List>");
        for (String key : productList.keySet()) {
            System.out.println(productList.get(key));
        }
    }

    // 자판기 시작 버튼 누르기
    public void pressStartButton(User user){
        this.user = user;
        this.isRunning = true;
        System.out.println("Please select what you want.\n");
        getProductDetail();
        System.out.println();
    }

    // 상품 결제
    @Override
    public void purchaseProduct(String productName) {

        try {
            Product product = productList.get(productName);

            if (user.getMoney() < product.getPrice()){
                user.getPaymentType().alert();
                isRunning = false;
                return;
            }

            pay(product);
            sale(product);
            addProductInShoppingList(productName);

            System.out.println("\n" + "Change : " + user.getMoney());

            getProductDetail();
        } catch (NullPointerException e) {
            // 자판기에 없는 상품을 달라고 하면 오류 발생
            System.out.println("There is no " + productName);
        } finally {
            // 계속 구매할지 물어보기
            System.out.println("Do you want to continue purchasing? (YES / NO)");
        }

    }

    public boolean getRunningStatus() {
        return isRunning;
    }

    public void setRunningStatus(AnswerType answerType) {

        try {
            switch (answerType){
                case YES :
                    break;
                case NO :
                    isRunning = false;
            }
        }catch (IllegalAccessError e){
            // TODO 잘못된 답변을 입력하는 경우. 답변 재입력할 수 있게 해야함.
            System.out.println("Please enter it again. (YES / NO)");
        }

    }

    // 보유금액 - 가격
    private void pay(Product product){
        user.setMoney(user.getMoney() - product.getPrice());
    }

    // 재고 - 구매 수량
    private void sale(Product product){
        product.setStock(product.getStock() - 1);
    }

    // 쇼핑리스트 추가
    private void addProductInShoppingList(String productName){

        // 처음 담는 상품일 때
        if (!user.getShoppingList().containsKey(productName)){
            user.getShoppingList().put(productName, 1);
        }else {
            // 이미 구매한 이력이 있는 경우
            user.getShoppingList().put(productName, user.getShoppingList().get(productName)+1);
        }

        // 쇼핑리스트 출력
        System.out.println("<Shopping List>");
        for (String key : user.getShoppingList().keySet()) {
            System.out.println(key + ": " + user.getShoppingList().get(key));
        }

    }
}
