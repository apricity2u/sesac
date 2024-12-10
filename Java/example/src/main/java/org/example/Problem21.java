package org.example;

public class Problem21 {

    // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
    // 클래스 이름은 유지

    public static void main(String[] args) {
        // 함수 실행
        //   Solution.solution();
    }

// ////////////////////////////////////////////////////////////////////////////////////
    // 이 부분에 daily algo의 템플릿 복사
    //    public (타입) solution 을
    //    public static (타입) solution 으로 변경
    class Solution {
        public static int solution(long number) {
            int answer = 0;

            // 1234 => 10으로 나눈 나머지로 구할 수 있음

            while(number != 0) {
                number = number / 10;
                answer += 1;
            }

            return answer;
        }
    }
/*
    class Solution {
        public int solution(long number) {
            int answer = 0;

            String stringNum = Long.toString(number);
            answer = stringNum.length();

            return answer;
        }
    }
 */
// ////////////////////////////////////////////////////////////////////////////////////
}
