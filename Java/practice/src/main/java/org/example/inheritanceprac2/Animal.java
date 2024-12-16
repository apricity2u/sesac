package org.example.inheritanceprac2;

public class Animal {
    protected String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void shoutOut(){
        System.out.println("shout out");
    }

    public int getAge(){
        return age;
    }
}
