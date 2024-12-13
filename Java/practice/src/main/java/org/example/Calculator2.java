package org.example;

public class Calculator2 {

    // this : 인스턴스
    // 설계도를 가지고 new Calculator2로 인스턴스를 만들었다.

    // 덧셈
    // 인스턴스에 구애를 받음
    int add(int num1, int num2){
        return num1 + num2;
    }

    // 메서드 시그니처와 오버로딩
    // 메서드 이름이 같아도, 매개변수의 개수나 타입이 다르면 다른 메서드로 인식
    int add(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }

    int add(double num1, double num2){
        return (int) (num1 + num2);
    }

    // class 입장에서 실행 가능 (바로 function 실행 가능)
    static int staticAdd(int num1, int num2) {
        return num1 + num2;
    }

    // 뺄셈
    int minus(int num1, int num2){
        return num1 - num2;
    }

    // 곱셈
    int multiply(int num1, int num2){
        return num1 * num2;
    }

    // 나눗셈
    int divide(int num1, int num2){
        return num1 / num2;
    }
}
