package org.example;

public class Main {
    public static void main(String[] args) {

        // 자판기 생성
        VendingMachine vendingMachine = new VendingMachine();

        // 상품 생성
        Product cola = new Beverages("cola", 1000, 5);
        Product cider = new Beverages("cider", 800, 8);
        Product chocolate = new Snack("chocolate", 1500, 2);
        Product candy = new Snack("candy", 300, 10);

        // 관리자 생성
        Manager manager = new Manager(vendingMachine);

        // 자판기에 상품 넣기
        manager.putProduct(cola);
        manager.putProduct(cider);
        manager.putProduct(chocolate);
        manager.putProduct(candy);

        // 사용자 생성
        User heather = new User(20000, "CARD");
        User sunny = new User(10000, "CASH");



    }

}
