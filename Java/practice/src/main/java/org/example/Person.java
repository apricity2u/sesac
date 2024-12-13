package org.example;

public class Person {

    String name;
    int age;

    // 기본 생성자 : 기본값 지정 시 활용 (매개변수가 없는 생성자)
    // 에러를 방지하기 위해 사용
    public Person() {
        this.name = "basic name";
        this.age = 18;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
