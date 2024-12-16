package org.example.modifierprac;

import org.w3c.dom.ls.LSOutput;

public class BankAccount {

    // 계좌는 잔액과 비밀번호 정보를 가진다
    // 잔액과 비밀번호는 외부에서 직접 접근할 수 없다
    // 변수는 보통 private으로 많이 사용한다. (외부 접근을 막기 위함)
    private int balance;
    private String password;

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

        /*
        if (!validateAmount(amount)){
         System.out.println("cannot deposit");

         // return에 아무것도 안 쓰면, 그냥 아무것도 반환하지 않고 멈춰버림
         return;
        }
        */

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

        /*
        if(!validatePassword(password)){
            System.out.println("invalid password");
            return;
        */

        /*
        if (!validateAmount(money)){
          System.out.println("cannot withdraw");
          return;
        }
         */

        // if (amount > balance){
        //  return;
        // }

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

        /*
        if(!validatePassword(password)){
            System.out.println("invalid password");
            return;
        */

        /* 만약에 return이 int면,
            1. 의미 없는 값을 return (대신. 타입에 맞춰서)
            2. 외부에서 에러 핸들링을 한다.
        if(!validatePassword(password)){
            return -1;
        }
        */

        // 비밀번호가 일치하면 잔액을 보여준다.
        if (password.equals(this.password)){
            System.out.println("balance: " + balance);
        }else {
            // 비밀번호 불일치 안내 메세지
            System.out.println("Incorrect password");
        }
    }

    // 기획단에서 천원 이하의 금액 입출금을 막고싶을 수도 있음
    // 그래서 함수로 빼놓고 나중에 금액만 수정하면, 연관된 기능들을 하나하나 수정하지 않아도 됨
    // minAmount만 수정하면 됨
    // 이런 기능은 전체에게 공개하면 안됨. 그래서 private으로..!
    // private boolean validateAmount(int amount, int minAmount){
    private boolean validateAmount(int amount){
        if (amount > 0) {
            return true;
        }else {
            System.out.println("under 0 impossible.");
            return false;
        }
    }

    // 비밀번호 확인용 함수
    private boolean validatePassword(String password){
        if (this.password.equals(password)){
            return true;
        }else{
            System.out.println("invalid password");
            return false;
        }
    }

    // 생성 시 비밀번호 유효성 검사 함수 (클래스 함수)
    public static boolean validateInitialPassword(String password) {
        if (password.length() >= 4){
            return true;
        }else {
            System.out.println("Please enter more than 3 words.");
            return false;
        }
    }

}
