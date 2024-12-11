package org.example;

public class Problem53 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행
            System.out.println(Solution.solution(new int[] {1, 2, 3, 4, 5, 6, 7 ,8, 9}, 3));

        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경
class Solution {
    public static  int[] solution(int[] numbers, int step) {

        //

        int answerLength = 1 + (numbers.length - 1) / step;

        int answerLength2 = (int) Math.ceil(((double) numbers.length) / step);


        int[] answer = new int[answerLength];

        int index = 0;
        for (int i = 0; i < numbers.length; i += step) {
            answer[index] = numbers[i];
            index++;

        }

        return answer;
    }
}
// ////////////////////////////////////////////////////////////////////////////////////
    }
