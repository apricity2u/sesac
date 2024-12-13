package org.example;

public class Dog {

    // 개체수
    static int count;

    String breed;
    String name;

    public Dog(String breed, String name){
        this.breed = breed;
        this.name = name;
        // 강아지들의 개체수를 늘릴 수 있음
        count++;
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
