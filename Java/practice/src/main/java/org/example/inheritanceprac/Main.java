package org.example.inheritanceprac;

public class Main {
    public static void main(String[] args) {

        Person.introduce();
        Student.introduce();

        Student s = new Student();
        s.study();

        Parent parent = new Parent("Parent Public value");
        System.out.println(parent.publicValue);
//        System.out.println(parent.privateValue);
        System.out.println(parent.protectedValue);
        parent.publicMethod();

        Child child = new Child("Child Public value", "child value");
        System.out.println(child.publicValue);
//        System.out.println(child.privateValue);
        System.out.println(child.protectedValue);
        child.publicMethod();
        child.childMethod();
    }
}
