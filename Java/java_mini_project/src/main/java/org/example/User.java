package org.example;

public class User {

    private int money;
    private PaymentType paymentType;

    public User(int money, PaymentType paymentType) {
        this.money = money;
        this.paymentType = paymentType;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
