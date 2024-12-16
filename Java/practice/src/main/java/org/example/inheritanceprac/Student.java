package org.example.inheritanceprac;

public class Student extends Person {

    // extends를 사용하면 Person에 있는 기능과 변수를 사용할 수 있음
//    String name;
//    int age;
    int studentNum;

    // 메서드 오버라이딩
    // 부모 클래스의 메서드를 덮어씌울 수 있음
    public static void introduce() {
        System.out.println("hello I'm student.");
    }

    public void study() {
        System.out.println("studying");
    }
}
