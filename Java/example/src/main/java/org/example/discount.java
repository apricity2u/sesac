package org.example;

public class discount {
    public static void main(String[] args) {

        class Solution {
            // 정가를 입력 받아 할인가를 int로 내보내는 함수
            public int solution(int totalPrice, String membership, String paymentMethod) {

                double result = totalPrice; // 정가를 복사한 할인가

                // 기본 할인
                if (totalPrice >= 500000) {
                    result = totalPrice * (1 - 0.15);
                    // result = discount(totalPrice, 0.15);
                }else if (totalPrice >= 300000) {
                    result = totalPrice * (1 - 0.10);
                }else if (totalPrice >= 100000) {
                    result = totalPrice * (1 - 0.05);
                }

                // 회원 등급별 추가 할인
                // 내가 확인하고 싶은 값이 ~ 맞니?
                // switch는 break가 없으면 모든 case를 확인함
                switch (membership){
                    case ("실버"):
                        result *= (1 - 0.03);
                        break;
                    case ("골드"):
                        result *= (1 - 0.05);
                        break;
                    case ("플래티넘"):
                        result *= (1 - 0.10);
                        break;
                }

                // 결제 방식별 추가 할인
                if (paymentMethod.equals("현금")) {
                    result *= (1-0.02);
                }

                // 특별 프로모션
                if (totalPrice >= 500000 && membership.equals("플래티넘") && paymentMethod.equals("현금")) {
                    result -= 50000;
                }

                return (int) result;
            }

            // discount(가격, 할인율) => 이렇게 함수로 빼는게 좋음
            // 왜냐하면 어떤 행동인지 알려주기 위함
        }
    }
}
