package org.example.collectionprac;

import java.util.ArrayList;
import java.util.List;

public class ListPractice {
    public static void main(String[] args) {
        // Student student = new Student();

        // Integer를 가지는 새로운 ArrayList
        // size가 자유로운 자료구조
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // data 삽입
        list.add(1);
        list.add(3);
        // 원래 클래스 + 난수가 나와야하는데, 자동으로 toString을 Override함.
        System.out.println(list);

        // 원하는 리스트 자리에 element 삽입
        list.add(1, 100);
        System.out.println(list);

        // data 접근
        System.out.println(list.get(1));
        System.out.println(list.getFirst());

        // data 수정
        list.set(1, 1000);
        System.out.println(list);

        // list를 반복을 돈다. "길이"
        System.out.println(list.size());

        // 원소가 존재하지 않음
        list.isEmpty();
        if (!list.isEmpty()){
            list.get(0);
        }

        for (Integer i : list) {
            System.out.println(i);
        }

        for (int index = 0; index < list.size(); index++) {
            int value = list.get(index);
        }


        List<String> strings = new ArrayList<>();
        strings.add("1");
        System.out.println(strings);
        strings.get(0);
        System.out.println(strings);
        strings.set(0, "100");
        System.out.println(strings);
    }
}
