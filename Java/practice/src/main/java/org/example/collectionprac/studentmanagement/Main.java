package org.example.collectionprac.studentmanagement;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ////////// Student 클래스 //////////

        // 학생
        Student jun = new Student("jun", 20);
        Student ken = new Student("ken", 20);
        Student beemo = new Student("beemo", 20);
        Student alex = new Student("alex", 20);
        Student lynda = new Student("lynda", 20);
        Student kyle = new Student("kyle", 20);

        // 학생 과목별 성적
        jun.saveScore("Korean", 100);
        jun.saveScore("Math", 100);
        jun.saveScore("CS", 100);
        ken.saveScore("Korean", 80);
        ken.saveScore("Math", 80);
        ken.saveScore("CS", 80);
        beemo.saveScore("Korean", 60);
        beemo.saveScore("Math", 60);
        beemo.saveScore("CS", 60);

        // 학생 성적 조회
        System.out.println(jun.getGrade());

        // 학생의 성적 평균 계산
        System.out.println(jun.scoreAverage());

        // 정보 조회
        jun.showInfo();

        // ////////// StudentManager 클래스 //////////

//        // 학생들의 목록
//        List<Student> studentList = new ArrayList<>();
//
//        // 학생 추가하기
//        studentList.add(jun);
//        studentList.add(ken);
//        studentList.add(beemo);
//        studentList.add(alex);
//        studentList.add(lynda);
//
//        // toString 을 override 해줘야 학생의 이름만 모아서 출력할 수 있다!
//        System.out.println(studentList);

        // 관리자
        StudentManager studentManager = new StudentManager();

        // 학생 추가하기
        studentManager.addStudent(jun);
        studentManager.addStudent(beemo);
        studentManager.addStudent(ken);

        // 학생 목록 조회
        studentManager.getStudentsInfo();

        // 학생들의 정보 조회
        studentManager.getStudentList();


    }
}
