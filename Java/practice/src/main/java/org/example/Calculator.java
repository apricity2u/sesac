package org.example;

public class Calculator {

    int num1;
    int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 덧셈
    int add(){
        return this.num1 + this.num2;
    }

    // 뺄셈
    int minus(){
        return this.num1 - this.num2;
    }
    // 곱셈
    int multiply(){
        return this.num1 * this.num2;
    }
    // 나눗셈
    // 나누면 double이 나올 수도 있지만, 통일성을 고려해서 int
    int divide(){
        return this.num1 / this.num2;
    }

}
