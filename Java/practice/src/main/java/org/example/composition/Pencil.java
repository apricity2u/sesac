package org.example.composition;

// Pencil을 도구로 사용하려면 인터페이스를 implement한다.
public class Pencil implements Usable {

    public String color;

    public Pencil(String color) {
        this.color = color;
    }

    public void write(){
        System.out.println("write with " + color + " pencil");
    }

    @Override
    public void use(){
        write();
    }
}
