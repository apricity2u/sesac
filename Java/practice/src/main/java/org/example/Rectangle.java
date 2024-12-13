package org.example;

public class Rectangle {

    // 사각형
    // 군집, 공통으로 가지고 있는 특징 : class 변수 (static 변수)
    // -> 각이 4개다
    static int angleCount = 4;

    // 인스턴스가 가져야하는 특징
    // 속성 (필드, 변수)
    int width;
    int height;

    /*
     this 객체 자신
     오른쪽: 입력,값 width
     왼쪽: 객체의 width 속성
    */
    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    // class에 있는 함수 : 메서드
    int calculateArea(){
        return width * height;
    }

}
