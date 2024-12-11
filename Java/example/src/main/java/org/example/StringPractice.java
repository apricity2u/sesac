package org.example;

import java.util.Arrays;
import java.util.SimpleTimeZone;

public class StringPractice {
    public static void main(String[] args) {
        String word1 = "hello";
        // System.out.println(word1);
        // System.out.println(word1 + " " + word1 + 21);

        String word2 = "banana";
        // System.out.println(word2.length());

        String word3 = "";
        String word4 = "    ";
        // System.out.println(word3.isEmpty()); // true
        // System.out.println(word4.isEmpty()); // false
        // System.out.println(word3.isBlank());
        // System.out.println(word4.isBlank());

        String word5 = "crazy";
        // System.out.println(word5.charAt(1)); // r
        char[] characters = word5.toCharArray();
        /*
        System.out.println(Arrays.toString(characters));

        for (char c : characters) {
            System.out.println(c); // char
            String s = String.valueOf(c);
            System.out.println(s); // String
        }
        */

        String word6 = "apple";
        // System.out.println(word6.contains("a")); // true
        // System.out.println(word6.indexOf("b")); // 없는 경우 -1
        // System.out.println(word6.indexOf("pp")); // 처음으로 매칭되는 곳의 인덱스 1

        String word7 = "    Hey!   ";
        // System.out.println(word7.trim());

        String word8 = "fffffff";
        // System.out.println(word8.replace("f", "a")); // aaaaaa
        // System.out.println(word8); // ffffff 원본은 변하지 않음!

        String word9 = "something";
        // System.out.println(word9.substring(1,3));
        // System.out.println(word9);

        String word10 = "burt's bees !";
        // String[] arrstring = word10.split(" ");
        // System.out.println(Arrays.toString(arrstring));

        String word11 = "hello";
        String word12 = new String("hello");

        //System.out.println(word11 == word12);
        // System.out.println(word11.equals(word12));

        String[] words = {"I", "am", "so", "sleepy"};
        String sentence = String.join("-", words);
        System.out.println(sentence);

    }
}
