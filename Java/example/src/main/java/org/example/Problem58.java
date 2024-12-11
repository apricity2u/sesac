package org.example;

public class Problem58 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행
//            System.out.println(Solution.solution();

        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경
class Solution {
    public int[] solution(int[] numbers, int start, int end) {
        int[] answer = new int[end - start + 1];

        int index = 0;
        for (int i = start; i <= end; i++) {
            answer[index] = numbers[i];
            index++;
            // 같은 코드
            answer[i - start] = numbers[i];
        }
        return answer;
    }
}

// ////////////////////////////////////////////////////////////////////////////////////
    }
