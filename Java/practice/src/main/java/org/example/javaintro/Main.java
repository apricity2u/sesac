package org.example.javaintro;

import org.example.javaintro.tmp.DefaultModifier;

public class Main {
    public static void main(String[] args) {
        PrivateModifier pm = new PrivateModifier();
        System.out.println(pm.publicNum);

        // private 변수 조회하기
        // 사용 불가
        // System.out.println(pm.privateNum);
        // getter로 private 변수 조회 가능
        System.out.println(pm.getPrivateNum());

        // private 변수 변경하기
        // setter로 변수 변경하기
        pm.setPrivateNum(100);
        System.out.println(pm.getPrivateNum());

        pm.publicHi();
        // private 메서드 가져오기
        // 사용 불가
        // pm.privateHi();
        // public 메서드 안에 private 메서드를 넣고 불러오기
        pm.sayHi();

        System.out.println(pm.defaultNum);


        DefaultModifier dm = new DefaultModifier();
        System.out.println(dm.publicString);
        // default 변수는 같은 패키지에서만 가져올 수 있어서 오류남
        // System.out.println(dm.defaultString);
    }
}
