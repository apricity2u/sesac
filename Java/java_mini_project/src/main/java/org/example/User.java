package org.example;

public class User {

    private int money;
    private String paymentType;

    public User(int money, String paymentType) {
        this.money = money;
        this.paymentType = paymentType;
    }

    public int getMoney() {
        return money;
    }

    public String getPaymentType() {
        return paymentType;
    }
}
