package org.example.interfaceprac;

public class Dog extends Animal{

    private String breed;

    // 추상 클래스도 어쨌든 클래스이기 때문에, 부모가 생성자가 있어서 자식도 있어야함
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("wang wang");
    }
}
