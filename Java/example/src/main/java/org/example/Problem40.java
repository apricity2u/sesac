package org.example;

public class Problem40 {

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
        public static int solution(String word, String target) {
            int answer = 0;

            // 1. substring 활용 방법
            for (int i = 0; i < word.length()-target.length()+1; i++){
                String subStringWord = word.substring(i, i + target.length());
                if (subStringWord.equals(target)){
                    answer++;
                }
            }

            // 2. 하나하나 비교하기
            // 다른 단어가 나오면 target과 같은 단어가 아니다.
            for (int i = 0; i <= word.length() - target.length(); i++){
                boolean isSame = true;

                for (int j = 0; j < target.length(); j++){
                    if (word.charAt(i+j) != target.charAt(j)){
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    answer++;
                }
            }

            return answer;
        }
    }

// ////////////////////////////////////////////////////////////////////////////////////
}
