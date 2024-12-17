package org.example.interfaceprac;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        Shape rectangle2 = new Rectangle();
        System.out.println(rectangle.calculateArea());

        Triangle triangle = new Triangle();
        Shape triangle2 = new Triangle();
        System.out.println(triangle.calculateArea());

        // new.Animal(); 불가능

        Dog dog = new Dog("happy", 18, "puddle");
        dog.makeSound();

        Cat cat = new Cat("kitty", 3);
        cat.makeSound();

        makeThemSound(cat);
    }

    public static void makeThemSound(Animal animal){
        System.out.println("cry!");
        animal.makeSound();
    }

//    public static void makeThemSound(Dog dog){
//        System.out.println("cry!");
//        dog.makeSound();
//    }
//
//    public static void makeThemSound(Cat cat){
//        System.out.println("cry!");
//        cat.makeSound();
//    }


}
