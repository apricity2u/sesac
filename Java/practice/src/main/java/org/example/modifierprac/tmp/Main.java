package org.example.modifierprac.tmp;

import org.example.modifierprac.Person;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("beemo", 18, 183.7);

        System.out.println(p1.getName());
        System.out.println(p1.age);

        // 같은 패키지에 없어서 default를 불러올 수 없음
        // System.out.println(p1.height);

    }
}
