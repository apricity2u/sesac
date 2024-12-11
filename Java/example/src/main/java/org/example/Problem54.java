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

            // 나머지 연산을 취하면, 자신의 자리로 찾아갈 수 있다.
            // i + direction이 음수일 수 있기 때문에, 나머지 연산을 하기 위해 numbers.length를 더해준다.

            // 나는 양수 / 음수인 경우를 나눠서 numbers.length를 - / +
            // 길이로 나눈 나머지와 연관이 있어서 나머지 연산으로 간소화할 수 있음
            int element = numbers[i];
            int newIndex = (i + direction + numbers.length) % numbers.length;
            answer[newIndex] = element;

            /*
            ex. direction이 양수일 때
            [1, 2, 3, 4] / d : 3

            [_, 1, 2, 3] [4, _, _, _]
             0  1  2  3   4
                          0 (numbers.length로 나눈 나머지)
            [_, _, 1, 2] [3, 4, _, _]
             0  1  2  3   4  5
                          0  1
            [_, _, _, 1] [2, 3, 4, _]
             0  1  2  3   4  5  6
                          0  1  2

            ex. direction이 음수일 때 (음수로 나누기 불가 -> numbers.length를 더해서 양수 인덱싱으로 접근)
            [1, 2, 3, 4] / d : -2

            [_, _, _, 1] [2, 3, 4, _]
                     -1   0  1  2  3
                      3  (numbers.length로 나눈 나머지)
            [_, _, 1, 2] [3, 4, _, _]
                  -2 -1   0  1  2  3
                   2  3
             */
        }

        return answer;
    }
}
// ////////////////////////////////////////////////////////////////////////////////////
}
