package org.example;

public class Problem32 {

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
    public static int solution(String word, String c) {
        int answer = 0;

        // 하나짜리 string을 char로 변경하려면?
        char target = c.charAt(0);

        char[] characters = word.toCharArray();

        for (char character : characters) {

            if (character == target) {
                answer++;
            }
        }

        return answer;
    }
}

// ////////////////////////////////////////////////////////////////////////////////////
}
