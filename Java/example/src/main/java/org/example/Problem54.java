package org.example;

public class Problem54 {

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
    public static int[] solution(int[] numbers, int direction) {
        int[] answer = new int [numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int element = numbers[i];

            // 나머지 연산을 취하면, 자신의 자리로 찾아갈 수 있다.
            // i + direction이 음수일 수 있기 때문에, 나머지 연산을 하기 위해 numbers.length를 더해준다.

            // 나는 양수 / 음수인 경우를 나눠서 numbers.length를 - / +
            // 길이로 나눈 나머지와 연관이 있어서 나머지 연산으로 간소화할 수 있음

            int newIndex = (i + direction + numbers.length) % numbers.length;
            answer[newIndex] = element;
        }

        return answer;
    }
}
// ////////////////////////////////////////////////////////////////////////////////////
}
