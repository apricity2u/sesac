package org.example.inheritanceprac;

public class Child extends Parent{
    public String childValue = "childValue";

    public Child(String publicValue) {
        // 부모의 생성자를 호출한다. (마치 부모를 만들어준 것처럼)
        // 생성자는 특별한 함수고, 부모의 rule을 따랐는지 알기 위해 super가 있어야 함
        super(publicValue);
    }

    // 자식만의 생성자 만들기
    public Child(String publicValue, String childValue) {
        super(publicValue);
        this.childValue = childValue;
    }

    public void childMethod(){
        System.out.println("childMethod");
    }

    // 메서드 오버라이딩
    // 부모의 메서드를 자식에서 덮어씌우기
    @Override
    public void publicMethod(){
        // 부모의 메서드 혹은 변수에 접근하는 super
        super.publicMethod();
        System.out.println(super.publicValue);
        // 자식에서 정의한 기능도 실행함.
        System.out.println("child public method");
    }

}
