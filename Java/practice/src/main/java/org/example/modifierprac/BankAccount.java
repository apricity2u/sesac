package org.example.modifierprac;

import org.w3c.dom.ls.LSOutput;

public class BankAccount {

    // 계좌는 잔액과 비밀번호 정보를 가진다
    // 잔액과 비밀번호는 외부에서 직접 접근할 수 없다
    private int balance;
    private final String password;

    // 계좌 생성 (비밀번호 설정)
    // 생성자로 비밀번호 설정 및 잔액 초기화
    // 생성하면 생성 메세지를 보여주는게 좋을 것 같다
    public BankAccount(String password) {
        this.balance = 0;
        this.password = password;
        System.out.println("Your account is available.");
    }

    // 입금
    public void deposit(int money) {
        // 음수 입력막기
        if (money > 0) {
            balance += money;
            System.out.println("deposit: " + money);
        }else {
            // 정확한 금액을 입력해달라는 메세지 보여주기
            System.out.println("Please enter more than 1won.");
        }
    }

    // 출금 (비밀번호 확인 필요)
    // 잔액보다 큰 금액은 출금할 수 없다.
    public void withdraw(int money, String password) {

        // 1. 음수 입력 막기
        if (money > 0) {
            // 2. 비밀번호 일치여부 먼저 확인
            // 비밀번호 일치하면
            if (password.equals(this.password)) {

                // 3. 잔액이 출금 금액보다 크거나 같으면
                // 출금 금액과 잔액을 보여준다.
                if (balance >= money) {
                    balance -= money;
                    System.out.println("withdraw: " + money + " balance: " + balance);
                } else {
                    // 잔액이 없을 때 안내 메세지
                    System.out.println("Insufficient balance");
                }

                // 비밀번호 불일치 안내 메세지
            } else {
                System.out.println("Incorrect password");
            }
        }else {
            // 정확한 금액을 입력하라는 메세지
            System.out.println("Please enter more than 1won.");
        }

    }

    // 잔액 조회 (비밀번호 확인 필요)
    public void getBalance(String password) {

        // 비밀번호가 일치하면 잔액을 보여준다.
        if (password.equals(this.password)){
            System.out.println("balance: " + balance);
        }else {
            // 비밀번호 불일치 안내 메세지
            System.out.println("Incorrect password");
        }
    }

}
