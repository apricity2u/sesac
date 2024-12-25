package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 자판기 생성
        VendingMachine vendingMachine = new VendingMachine();

        // 상품 생성
        Product cola = new Beverages("cola", 1000, 5, "cold");
        Product cider = new Beverages("cider", 800, 8, "cold");
        Product chocolate = new Snack("chocolate", 1500, 2, "bar");
        Product candy = new Snack("candy", 300, 10, "stick");

        // 관리자 생성
        Manager manager = new Manager(vendingMachine);

        // 자판기에 상품 넣기
        manager.putProduct(cola);
        manager.putProduct(cider);
        manager.putProduct(chocolate);
        manager.putProduct(candy);

        // 사용자 생성
        User heather = new User(5000, PaymentType.CARD);
        User sunny = new User(3000, PaymentType.CASH);

        // 자판기 시작 버튼 누르기
        vendingMachine.pressStartButton(heather);

        while (vendingMachine.getRunningStatus()) {
            // 구매할 제품 입력
            Scanner scanner = new Scanner(System.in);
            String itemName = scanner.next();

            // 자판기에서 결제 진행
            vendingMachine.purchaseProduct(itemName);

            // 계속 구매할지 물어보기
            String continueToBuyProduct = scanner.next();
            vendingMachine.setRunningStatus(AnswerType.valueOf(continueToBuyProduct));
        }

        /* 관리자 메서드 정상 작동!
        manager.addStock("cola", 10);
        manager.changePrice("cola", 500);
        vendingMachine.getProductDetail();
        manager.getRevenue();
         */
    }

}
