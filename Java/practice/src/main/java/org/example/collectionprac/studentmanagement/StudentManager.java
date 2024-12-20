package org.example.collectionprac.studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    // 학생들의 목록
    private List<Student> studentlist;

    // 학생들의 목록을 가지고 있음.
    public StudentManager() {
        this.studentlist = new ArrayList<>();
    }

    // 학생 추가
    // 이것도 1. students return 2. void return
    public void addStudent(Student newStudent){
        studentlist.add(newStudent);
    }

    public List<Student> addStudent2(Student newStudent){
        studentlist.add(newStudent);
        return studentlist;
    }

    // 학생 목록 확인 (이름만 조회할 때)
    public void getStudentList() {
        System.out.println(studentlist);
    }

    // 연습 : 학생 이름만 담은 리스트를 만들어서 반환
    public List<String> getStudentList2() {

        List<String> studentNames= new ArrayList<>();

        for (Student student : studentlist) {
            studentNames.add(student.getName());
        }

        return studentNames;
    }

    // 학생들 정보 조회
    public void getStudentsInfo() {

        for (Student student : studentlist) {
            student.showInfo();
            System.out.println();
        }
    }

    // 특정 학생 조회하기
    // 우리가 기획을 탄탄하게 하고 어떤게 필요한지에 따라 return 타입이 정해지는 것
    public Student getStudentByName(String name) {
        // 이름이 같은 학생을 return하자.
        for (Student student : studentlist) {
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    public void findStudentByName(String name) {

        for (Student student : studentlist) {
            if (student.getName().equals(name)){
                student.showInfo();
                return;
            }
        }

        System.out.println("Cannot find " + name);
    }

}
