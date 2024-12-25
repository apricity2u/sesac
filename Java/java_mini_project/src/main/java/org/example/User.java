package org.example;

import java.util.HashMap;
import java.util.Map;

public class User {

    protected int money;
    protected final PaymentType paymentType;
    protected Map<String, Integer> shoppingList;

    public User(int money, PaymentType paymentType) {
        this.money = money;
        this.paymentType = paymentType;
        this.shoppingList = new HashMap<String, Integer>();
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

    public Map<String, Integer> getShoppingList() {
        return shoppingList;
    }

}
