package org.example.streamprac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);


//        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 2, 4));
        System.out.println(list);

        // list를 stream으로 변경
        List<Integer> over1List = list.stream()
                .filter(x -> x > 1) // filter 적용
                .collect(Collectors.toList());// list로 변경

        System.out.println(over1List);

        System.out.println("-------------------------\n");

        // List<Integer>

        // 짝수만 필터링하여 리스트 반환
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> overList = numbers.stream()
                .filter(x -> x % 2 == 0)
                .toList();

        System.out.println(overList);

        // 모든 숫자에 2를 곱하여 리스트 반환
        List<Integer> multipleList = numbers.stream()
                .map(x -> x*2)
                .toList();

        System.out.println(multipleList );

        // 숫자들의 합계 계산
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

        // 5보다 큰 숫자의 개수 계산
        long count = numbers.stream()
                .filter(x -> x > 5)
                .count();

        System.out.println(count);

        System.out.println("-------------------------\n");

        // List<String>

        List<String> words = Arrays.asList("apple", "banana", "cherry", "fineapple", "apple");

        // 길이가 5이상인 단어들만 필터링하여 리스트 반환
        List<String> aboveFive = words.stream()
                .filter(x -> x.length() >= 5)
                .toList();

        System.out.println(aboveFive);

        // 모든 단어들을 대문자로 변환하여 리스트 반환
        List<String> upperList = words.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upperList);

        // 중복된 단어 제거하고 알파벳 순 정렬하여 리스트 반환
        List<String> sortedList = words.stream()
                .distinct()
                .sorted()
                .toList();

        System.out.println(sortedList);

        // 각 단어의 길이를 리스트로 변환
        List<Integer> wordsLength = words.stream()
                .map(String::length)
                .toList();

        System.out.println(wordsLength);

        System.out.println("-------------------------\n");

        // Product class, (name, price)

        List<Product> products = Arrays.asList(
                new Product("notebook", 1200000, "SALE"),
                new Product("mouse", 50000, "SALE"),
                new Product("keyboard", 150000, "SOLD_OUT"),
                new Product("monitor", 350000, "SOLD_OUT"),
                new Product("speaker", 400000, "SALE")
        );

        // 상품들의 이름 리스트 반환
        List<String> productNames = products.stream()
                .map(Product::getName)
                .toList();

        System.out.println(productNames);

        // 20만원 이상인 상품들의 이름 리스트 반환
        List<String> overTwenty = products.stream()
                .filter(x -> x.getPrice() >= 200000)
                .map(Product::getName)
                .toList();

        System.out.println(overTwenty);

        // 판매중인 상품의 가격 합
        int productSum = products.stream()
                .filter(x -> x.getStatus().equals("SALE"))
                .mapToInt(Product::getPrice)
                .sum();

        System.out.println(productSum);

        // 판매 중이면서 20만원 이상인 상품들의 이름 리스트 반환
        List<String> uniqueProduct = products.stream()
                .filter(x -> x.getStatus().equals("SALE"))
                .filter(x -> x.getPrice() >= 200000)
                .map(Product::getName)
                .toList();

        System.out.println(uniqueProduct);

    }
}
