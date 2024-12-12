package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(100,200);
        System.out.println(r1.calculateArea());

        Circle c1 = new Circle(3);
        System.out.println(c1.radius);
        // Circle 이라는 클래스의 method 사용 가능
        // ex. string1.length(
        System.out.println(c1.calculateArea());

        Person kyle = new Person("kyle", 20);
        Person kyle2 = new Person("kyle", 20);
        System.out.println(kyle.name);
        System.out.println(kyle.age);
        System.out.println(kyle == kyle2); // false

        Dog dog1 = new Dog("poodle", "bobbi");
        System.out.println(dog1.dogAction("sit"));
        System.out.println(dog1.dogAction("hand"));
        dog1.sit();
        dog1.hand();

        Triangle t1 = new Triangle(4);
        System.out.println(t1.circumference());
        System.out.println(t1.calculateArea());

        Car car1 = new Car("Avante");
        car1.increaseSpeed();
        car1.increaseSpeed();
        car1.increaseSpeed();
        car1.decreaseSpeed();
        car1.getInfo();
        car1.increaseSpeedByAmount(110);
        car1.getInfo();

        MP3Player mp3 = new MP3Player("iPod");
        mp3.pushPowerButton(); // mp3.turnOn();
        mp3.volumeUp();
        mp3.volumeUp();
        mp3.volumeUp();
        mp3.volumeDown();
        mp3.getInfo();

    }
}
/*
 * class의 3가지 공간
 * 변수
 * 생성자
 * 메서드
 *
 *
 * class는 그 자체로 타입이다
 * 내가만드는 타입
 * */


/*
 * class로 만든 것이 객체, 인스턴스
 *
 * class로 만든어진 객체로 무엇인가를 한다
 *
 * 인스턴스: 어떠한 클래스로 부터 만들어진 자식이다라는 것을 설명하기 위한 대표명사(대명사)
 * 객체 : 인스턴스와 동일한 의미지만 인스턴스가 특정되는 것
 *
 * 어린이(클래스) 철수(객체)
 * 객체인 철수는 어린이 클래스의 인스턴스
 *
 *
 * */
