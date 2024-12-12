package org.example;

public class Triangle {

    // 정삼각형
    // 한 변의 길이
    int side;
    // 둘레의 길이
    // 둘레의 길이 자주 사용한다면 변수로 지정하는게 나을 수도 있음
    // int circumference;

    Triangle(int side) {
        this.side = side;
        // this.circumference = side * 3;
    }

    // 둘레의 길이를 가끔만 사용하면 메서드로 따로 빼기
    int circumference() {
        return 3 * side;
    }

    double calculateArea() {
        double area = (Math.sqrt(3) / 4) * side * side;
        // 몇 번째 소수점까지 볼지 정할 때
        area = Math.floor(area*100)/100;
        return area;
        // return (double) side * height / 2;
    }

}
