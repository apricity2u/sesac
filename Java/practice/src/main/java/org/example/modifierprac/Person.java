package org.example.modifierprac;

public class Person {

    // - 같은 클래스 내에서만 접근할 수 있는 이름(String name) 변수를 작성하시오.
    private String name;

    //- 모든 곳에서 접근할 수 있는 나이(int age) 변수를 작성하시오.
    public int age;

    //- 같은 패키지 내에서만 접근할 수 있는 키(double height) 변수를 작성하시오.
    double height ;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    //

    //- 같은 클래스 내에서만 접근할 수 있는 “달리기” 메서드를 작성하시오.
    private void run(){
        System.out.println("run - private");
    }

    //- 모든 곳에서 접근할 수 있는 “걷기” 메서드를 작성하시오.
    public void walk(){
        System.out.println("walk - public");
    }

    //- 같은 패키지 내에서만 접근할 수 있는 “공부하기” 메서드를 작성하시오.
    void study(){
        System.out.println("study - default");
    }

    //- 접근할 수 없는 변수를 사용하기 위한 메서드를 작성하시오.
    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public void publicRun() {
        run();
    }

}
