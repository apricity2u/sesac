package org.example;

public class Beverages extends Product {

    private String beveragesFeature;

    public Beverages(String name, int price, int stock, String beveragesFeature) {
        super(name, price, stock);
        this.beveragesFeature = beveragesFeature;
    }

}
