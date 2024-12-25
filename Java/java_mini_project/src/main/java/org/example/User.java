package org.example;

public class User {

    private int money;
    private final PaymentType paymentType;

    public User(int money, PaymentType paymentType) {
        this.money = money;
        this.paymentType = paymentType;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public void putMoney(int amount) {
        money += amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
