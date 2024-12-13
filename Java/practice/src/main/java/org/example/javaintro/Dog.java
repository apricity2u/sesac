package org.example.javaintro;

public class Dog {

    // 개체수
    public static int count;

    public String breed;
    public String name;

    public Dog(String breed, String name){
        this.breed = breed;
        this.name = name;
        // 강아지들의 개체수를 늘릴 수 있음
        count++;
    }

    public String dogAction(String action) {
        return this.name + ' ' + action;
    }

    public void sit() {
        System.out.println(this.name + " sit");
    }

    public void hand() {
        System.out.println(this.name + " hand");
    }

}
