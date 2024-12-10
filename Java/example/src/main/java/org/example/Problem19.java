package org.example;

public class Problem19 {

    // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
    // 클래스 이름은 유지

    public static void main(String[] args) {
        // 함수 실행
        System.out.println(Problem19.Solution.solution(1, 10));
    }

// ////////////////////////////////////////////////////////////////////////////////////
    class Solution {
        public static int solution(int start, int end) {
            int answer = 0;

            for (int i = start; i <= end; i++) {

                if(i % 2 == 0) {
                    answer += i;
                }
            }

            return answer;
        }
    }
// ////////////////////////////////////////////////////////////////////////////////////
}
