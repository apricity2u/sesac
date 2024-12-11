package org.example;

import java.util.Arrays;

public class Problem57 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행
//            System.out.println(Solution.solution(new int[] {1, 2, 3}, new int[] {4, 5, 6}));

        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경
class Solution {
    public  static int[] solution(int[] numbers, int n) {
        int[] answer = new int[numbers.length * n ];

        int index = 0;
        for (int i = 0; i < n; i++) {

            for (int number : numbers) {
                answer[index] = number;
                index++;
            }

        }

        return answer;
    }
}
// ////////////////////////////////////////////////////////////////////////////////////
    }
