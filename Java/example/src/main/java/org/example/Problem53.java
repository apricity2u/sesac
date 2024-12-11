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

        // 0번째 인덱스 값은 무조건 포함하므로 1 더해주기
        // numbers.length에서 0번째 인덱스를 이미 더했기 때문에 1 빼고 step으로 나누기
        // 이렇게 하면 length를 step으로 나눴을 때, 나누어 떨어지지 않는 경우도 포함할 수 있다

        // 첫번째 방법
        // ex. 4 / 2 => 1 + ( 4 - 1 )/2
        // ex. 5 / 3 => 1 + ( 5 - 1 )/3
        int answerLength = 1 + (numbers.length - 1) / step;

        // 두번째 방법
        // 소수점 생기면 무조건 올림해 => 실수로 만들어야함(double)
        // 올림 Math.ceil
        // ex. 5 / 3 => 1.6XXX  올림하면 2
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
