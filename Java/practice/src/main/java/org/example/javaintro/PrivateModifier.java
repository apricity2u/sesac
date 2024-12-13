package org.example.javaintro;

public class PrivateModifier {

    public int publicNum = 1;
    private int privateNum = 10;
    int defaultNum = 100;

    // getter
    // private 값을 가져올 수 있는 getter
    public int getPrivateNum() {
        return privateNum;
    }

    // setter
    public void setPrivateNum(int privateNum) {
        this.privateNum = privateNum;
    }



    public void publicHi() {
        System.out.println("hi, public");
    }

    private void privateHi() {
        System.out.println("hi, private");
    }

    public void sayHi() {
        privateHi();
    }

}
