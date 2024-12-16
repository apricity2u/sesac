package org.example.inheritanceprac2;

public class Dog extends Animal{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void shoutOut() {
        System.out.println(name + ": Bow Wow!");
    }
}
