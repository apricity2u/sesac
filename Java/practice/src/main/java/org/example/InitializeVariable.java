package org.example;

public class InitializeVariable {
    public static void main(String[] args) {

        V1 v1 = new V1();
        System.out.println(v1.value);

        V2 v2 = new V2();
        System.out.println(v2.value);

        V3 v3 = new V3();
        System.out.println(v3.value);
    }
}

// 명시적인 초기화
// 인스턴스 변수에는 사용하지 않는게 좋음
class V1{

    // static 변수 (클래스 변수)는 여기에서 초기화 (생성자에서 초기화 불가)
    static int staticValue = 30;

    int value = 10;
    String word = "Text";
}

// 생성자를 이용한 초기화 (주로 사용 - 인스턴스 변수)
class V2{
    int value;
    String word;

    // 기본값 만들기
    public V2() {
        this(10, "Text");
    }

    public V2(int value, String word) {
        this.value = value;
        this.word = word;
    }
}

// 인스턴트에 대한 초기화 블록을 이용한 초기화
class V3{
    static int staticValue;

    int value;
    String word;

    // 혹시나 static 변수에 복잡한 로직이 필요할 때 활용
    static {
        if (true) {
            staticValue = 30;
        }else {
            staticValue = 50;
        }
    }

    // 자신만의 스코프를 가지고 있어서, for문도 사용 가능
    // 생성자가 가진 공통적인 로직이 필요할 때 활용하기
    {
        if (true) {
            this.value = 10;
        }else {
            this.value = 12;
        }

        this.word = "Text";
    }
}