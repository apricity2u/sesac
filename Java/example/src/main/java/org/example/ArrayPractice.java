package org.example;

import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int number = 10;

        // 가변길이가 아닌 고정길이를 가지고 있음
        // 타입[] : 해당 타입을 가진 배열이 생김
        // 길이가 5짜리인 배열을 만들기 (size)
        int[] numbers1;
        numbers1 = new int[5];

        // 데이터가 int 라는 것을 알려줘야 함 (data)
        // 데이터를 할당할 때 중괄호 사용
        int[] numbers2;
        numbers2 = new int[] {1, 2, 3, 4, 5};

        int[] numbers3 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(numbers1));
        // [0, 0, 0, 0, 0]
        // 참조형이어서 눈으로 확인하려면 string으로 변경
        System.out.println(Arrays.toString(numbers2));
        // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(numbers3));
        // [1, 2, 3, 4, 5]

        System.out.println(numbers2 == numbers3);
        // false (같은 주소값을 가리키는지 확인 : 참조자료형이라 false)
        System.out.println(Arrays.equals(numbers2, numbers3));
        // true (데이터 값이 같은지 확인)

        System.out.println(numbers2.length); // 5

        char[] chars = {'a', 'b', 'c', 'd'};
        for (int i=0; i < chars.length; i++) {
            char element = chars[i];
            System.out.println(element); // a b c d
        }

        // for ... in(of)
        // 타입 데이터 원소 : 컨테이너
        for (char element : chars) {
            System.out.println(element); // a b c d
        }

    }
}
