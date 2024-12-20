package org.example.collectionprac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Practice {
    public static void main(String[] args) {

        //- String타입의 ArrayList를 만들고, 주어진 메서드들을 연습하시오.
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add(1,"b?");
        System.out.println(strings);
        System.out.println(strings.get(3));
        strings.set(1, "b!");
        System.out.println(strings);
        System.out.println(strings.size());

        if (!strings.isEmpty()) {
            System.out.println(strings.get(3));
        }else {
            System.out.println("add some elements");
        }

        System.out.println(strings.contains("a"));
        strings.remove(1);
        System.out.println(strings);


        //- Key와 Value가 모두 String 타입인 HashMap을 만들고, 주어진 메서드들을 연습하시오.

        HashMap<String, String> map = new HashMap<>();

        map.put("1", "red");
        map.put("2", "orange");
        map.put("3", "yellow");
        map.put("4", "green");
        map.put("4", "purple");
        System.out.println(map);
        System.out.println(map.get("4"));
        System.out.println(map.getOrDefault("5", "none"));
        System.out.println(map.size());
        System.out.println(map.containsKey("3"));
        System.out.println(map.containsValue("purple"));
        map.remove("4");
        System.out.println(map);

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        //- String 타입의 HashSet을 만들고, 주어진 메서드들을 연습하시오.

        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.addAll(strings);
        System.out.println(set);
        System.out.println(set.size());

        if (!set.isEmpty()){
            set.remove("1");
        }
        System.out.println(set);


        //- 30, 20, 10이 들어있는 ArrayList를 만들고, 합계와 평균을 계산하시오

        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(30);
        integerArrayList.add(20);
        integerArrayList.add(10);

        int total = 0;
        double avg = 0;
        for (Integer el : integerArrayList) {
            total += el;
        }
        avg = (double) total / integerArrayList.size();
        System.out.println(total);
        System.out.println(avg);



    }
}
