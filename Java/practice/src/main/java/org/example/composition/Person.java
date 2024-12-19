package org.example.composition;

public class Person {

    private String name;
    private Pencil pencil;
    // 연필 여러개 가지기
    private Pencil[] pencils;
    // 사람이 도구를 갈아끼울 수 있게 하려면?
    // '도구'라는 것을 인터페이스로 만들어주면 된다.
    private Usable tool;

    public Person(String name, Usable tool) {
        this.name = name;
        this.tool = tool;
    }

//    public Person(String name, Pencil pencil) {
//        this.name = name;
//        this.pencil = pencil;
//    }
//
    public Person(String name, Pencil[] pencils) {
        this.name = name;
        this.pencils = pencils;
    }

    // 사용한다!
    public void use(){
        tool.use();
    }

    public void write(){
        pencil.write();
    }

    // 연필을 여러개 쓰기
    public void writeMany(){
        for (Pencil p : pencils) {
            p.write();
        }
    }

    public void setPencil(Usable pencil){
        tool = pencil;
    }

    public void setTool(Usable tool) {
        this.tool = tool;
    }
}
