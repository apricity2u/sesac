package org.example.collectionprac.studentmanagement;

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
        System.out.println("-----get student's grade-----");
        System.out.println(jun.getGrade());

        // 학생의 성적 평균 계산
        System.out.println("-----get grade average-----");
        System.out.println(jun.scoreAverage());

        // 정보 조회
        System.out.println("-----get Student info-----");
        jun.showInfo();

        // ////////// StudentManager 클래스 //////////

        // 관리자
        StudentManager studentManager = new StudentManager();

        // 학생 추가하기
        studentManager.addStudent(jun);
        studentManager.addStudent(beemo);
        studentManager.addStudent(ken);

        // 학생 검색하기
        System.out.println("-----Student return-----");
        Student b = studentManager.getStudentByName("jun");
        b.showInfo();

        System.out.println("-----void return-----");
        studentManager.findStudentByName("beemo");
        studentManager.findStudentByName("kyle");

        // 학생들의 정보 조회
        System.out.println("-----get Students Info-----");
        studentManager.getStudentsInfo();

        // 학생 목록 조회 (이름만 모아서)
        System.out.println("-----get Student List-----");
        studentManager.getStudentList();

        System.out.println(studentManager.getStudentList2());


    }
}
