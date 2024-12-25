package org.example;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Payable {

    // 상품을 여러 개 가지고 있다. (Map 사용)
    protected Map<String, Product> productList;
    // 자판기는 유저 정보를 가지고 있다.
    private User user;
    // 자판기 작동중
    private boolean isRunning;
    // 판매 목록
    protected Map<String, Integer> salesList;

    public VendingMachine() {
        this.productList = new HashMap<String, Product>();
        this.user = null;
        this.isRunning = false;
        this.salesList = new HashMap<String, Integer>();
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
        getProductDetail();
        System.out.println();
        System.out.println("Please select what you want.");
    }

    // 상품 결제
    @Override
    public void purchaseProduct(String productName) {

        try {
            Product product = productList.get(productName);

            // 돈이 없으면, 결제 수단에 따라 경고창 띄우고 자판기 중지
            if (user.money < product.price){
                user.paymentType.alert();
                isRunning = false;
                return;
            }

            // 재고가 없으면, 구매 불가
            if (product.stock == 0){
                System.out.println("It is out of stock.");
                return;
            }

            pay(product);
            sale(product);
            addProductInShoppingList(productName);
            addProductInSalesList(productName);

            System.out.println("\n" + "Change : " + user.money);
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
        user.setMoney(user.money - product.price);
    }

    // 재고 - 구매 수량
    private void sale(Product product){
        product.setStock(product.stock - 1);
    }

    // 쇼핑리스트 추가
    private void addProductInShoppingList(String productName){

        // 처음 담는 상품일 때
        if (!user.shoppingList.containsKey(productName)){
            user.shoppingList.put(productName, 1);
        }else {
            // 이미 구매한 이력이 있는 경우
            user.shoppingList.put(productName, user.shoppingList.get(productName)+1);
        }

        // 쇼핑리스트 출력
        System.out.println("<Shopping List>");
        for (String key : user.shoppingList.keySet()) {
            System.out.println(key + ": " + user.shoppingList.get(key));
        }

    }

    // 판매 목록에 추가
    private void addProductInSalesList(String productName) {
        // 처음 담는 상품일 때
        if (!salesList.containsKey(productName)){
            salesList.put(productName, 1);
        }else {
            // 이미 구매한 이력이 있는 경우
            salesList.put(productName, salesList.get(productName)+1);
        }
    }
}
