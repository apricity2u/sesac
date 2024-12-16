package org.example.inheritanceprac2;

public class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void shoutOut(){
        System.out.println(name + ": meow!");
    }

    public void purring(){
        System.out.println("purring~~~");
    }
}
