package org.example.etc;

// 클래스 차원에서 타입을 지정한다는 뜻. => 제네릭 사용
// 인스턴스 생성 시에 타입 지정!

// ArrayList<> 이렇게 되어있는 것과 같은 맥락
// HashMap처럼 타입을 2개 받아도 됨. 3. 4. 5...
public class GenericPrac<T> {

// Number를 extends한 클래스만 타입으로 넣을 수 있게 제한
//public class GenericPrac<T extends Number> {

    // 만약에 타입을 계속 변경하고 싶다면?
    // 타입 자리에 변수를 넣으면 됨.

    public T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }
}
