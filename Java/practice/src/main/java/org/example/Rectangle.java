package org.example;

public class Rectangle {

    int width;
    int height;

    /*
     * this 객체 자신
     *
     * 오른쪽: 입력,값 width
     * 왼쪽: 객체의 width 속성
     * */
    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    /*
     * class에 있는 함수를 메소드라 부른다
     *
     *
     * */
    int calculateArea(){
        return width * height;
    }

}
