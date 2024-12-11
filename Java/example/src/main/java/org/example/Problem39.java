package org.example;

public class Problem39 {

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
    public static boolean solution(String word) {

        StringBuilder stringBuilderWord = new StringBuilder(word);
        String reversedWord = stringBuilderWord.reverse().toString();

        return word.equals(reversedWord);
    }
}

class Solution2 {
    public static boolean solution(String word) {

        /*
        회문이란? 가운데를 중심으로 양쪽이 똑같은 값을 가진 것.
        => 양쪽이 같은 값을 가지지 않으면 회문이 아니다! (투포인터 알고리즘)

        word를 반복을 돌면서, 왼쪽 포인터와 오른쪽 포인터가 가리키는 값을 비교
        - 다르면 false로 바꾸고 다른 거 보기
        - 왼=>오 +1 / 오=>왼 -1
         */

        // 오른쪽 포인터는 오른쪽 맨 끝에서 시작
        int left = 0;
        int right = word.length() - left;
        boolean isPal = true;

        // 왼쪽 포인터와 오른쪽 포인터가 같거나 스위치 되기 전까지
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                isPal = false;
                break;
            }
            left++;
            right--;
        }

        // for (int left = 0; left < word.length()/2; left++) {
        //      int right = word.length() -1 - left;
        // }

        return isPal;
    }
}

// ////////////////////////////////////////////////////////////////////////////////////
}
