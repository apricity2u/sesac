package org.example.collectionprac;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
        // Key 자리에는 immutable한 것이 와야함 (불변 값)
        HashMap<String, Integer> map = new HashMap<>();

        // js : map[korean] = 100;
        map.put("Korean", 100);
        map.put("English",60);
        map.put("Math", 20);
        System.out.println(map);

        map.put("Korean", 30);
        System.out.println(map);

        // 조회
        System.out.println(map.get("Korean"));
        System.out.println(map.get("science")); // 없는 키 값이라 null
        System.out.println(map.getOrDefault("science", 0)); // null 대신 0이 보임
        System.out.println(map.getOrDefault("Korean", 0));

        // 크기
        System.out.println(map.size());

        // key들의 집합
        // key는 중복 불가해서 keySet
        Set<String> keys = map.keySet();

        for (String key : keys) {
            Integer value = map.get(key);
            System.out.println(key + " " + value);
        }

        System.out.println(map.values());

    }
}
