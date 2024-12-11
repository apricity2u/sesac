package org.example;

public class ArrayPractice2 {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        // 배열의 길이 구하기
        int myLength = 0;

        for (int i = 0; i < numbers.length; i++) {
            myLength += 1;
        }

        System.out.println(myLength);

//        //////////////////////////////////////////////////////

        // 배열의 최솟값 구하기
        // int minNum = Integer.MAX_VALUE;
        // 0번째는 배열이 비어있지 않을 때만 가능
        int minNum = numbers[0];

        /*
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNum) {
                minNum = numbers[i];
            }
        }
        */

        for (int number : numbers) {
            if (number < minNum) {
                minNum = number;
            }
        }

        System.out.println(minNum);

//        //////////////////////////////////////////////////////

        // 배열의 최댓값 구하기
        // int minNum = Integer.MIN_VALUE;
        int maxNum = numbers[0];

        /*
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNum) {
                maxNum = numbers[i];
            }
        }
        */

        for (int number : numbers) {
            if (number > maxNum) {
                maxNum = number;
            }
        }

        System.out.println(maxNum);

//        //////////////////////////////////////////////////////

        // 배열의 총합 구하기
        int mySum = 0;

        /*
        for (int i = 0; i < numbers.length; i++) {
            mySum += numbers[i];
        }
        */

        for (int number : numbers) {
            mySum += number;
        }

        System.out.println(mySum);
    }
}
