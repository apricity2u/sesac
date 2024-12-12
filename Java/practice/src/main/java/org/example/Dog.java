package org.example;

public class Dog {

    String breed;
    String name;

    public Dog(String breed, String name){
        this.breed = breed;
        this.name = name;
    }

    String dogAction(String action) {
        return this.name + ' ' + action;
    }

    void sit() {
        System.out.println(this.name + " sit");
    }

    void hand() {
        System.out.println(this.name + " hand");
    }

}
