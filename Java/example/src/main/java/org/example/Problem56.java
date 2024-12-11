package org.example;

import java.util.Arrays;

public class Problem56 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행
            System.out.println(Solution.solution(new int[] {1, 2, 3}, new int[] {4, 5, 6}));

        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경
class Solution {
    public static  int[] solution(int[] numbers1, int[] numbers2) {
        int[] answer = new int[numbers1.length + numbers2.length];

        // 첫번째 방법
        // answer의 index 조작
        int index = 0;
        for (int number : numbers1) {
            answer[index] = number;
            index++;
        }
        for (int number : numbers2) {
            answer[index] = number;
            index++;
        }

        // 두번째 방법
        // index를 따로 설정하지 않고, numbers1.length + i 로 answer의 나머지 인덱스 접근
        int[] answer2 = new int[numbers1.length + numbers2.length];

        for (int i = 0; i < numbers1.length; i++) {
            answer2[i] = numbers1[i];
        }

        for (int i = 0; i < numbers2.length; i++) {
            answer2[numbers1.length + i] = numbers2[i];

        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
// ////////////////////////////////////////////////////////////////////////////////////
    }
