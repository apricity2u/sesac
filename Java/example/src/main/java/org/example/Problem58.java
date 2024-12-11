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

            // 첫번째 방법
            // index 변수를 만들어서 활용하기
            answer[index] = numbers[i];
            index++;

            // 두번째 방법
            // answer에는 0번 인덱스부터 접근해야하니까 i - start해주면 됨
            // ex. start = 2
            // answer[2-2], answer[3-2], answer[4-2] ...

            answer[i - start] = numbers[i];
        }
        return answer;
    }
}

// ////////////////////////////////////////////////////////////////////////////////////
    }
