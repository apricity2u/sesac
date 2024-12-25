package org.example;

public class Snack extends Product {

    private String snackFeature;

    public Snack(String name, int price, int stock, String snackFeature) {
        super(name, price, stock);
        this.snackFeature = snackFeature;
    }

}
