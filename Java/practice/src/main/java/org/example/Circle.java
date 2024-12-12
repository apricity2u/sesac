package org.example;

public class Circle {

    // 반지름
    int radius;

    // 생성자
    Circle(int radius) {
        this.radius = radius;
    }

    // 기능 (method)
    // calculateArea의 return 타입이 double이다.
    double calculateArea() {
        return 3.14 * radius * radius;
    }

}
