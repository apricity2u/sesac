package org.example.interfaceprac;

public abstract class Animal {

    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 동물들이 공통적으로 내는 소리는 없고, 자식이 각자의 소리를 가지고 있음
    // 추상 메서드
    public abstract void makeSound();

}
