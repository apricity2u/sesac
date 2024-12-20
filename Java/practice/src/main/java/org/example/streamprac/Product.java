package org.example.streamprac;

public class Product {

    private String name;
    private int price;
    private String status;

    public Product(String name, int price, String status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
