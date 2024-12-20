package org.example.collectionprac.studentmanagement;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private String name;
    private int age;
    private Map<String, Integer> grade;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        // 앞에서 제네릭 타입을 정해줘서, 여기서는 입력 안해도 됨.
        this.grade = new HashMap<>();
    }

    // /////////////////////////// 과목별 성적 저장하기 ///////////////////////////

    // 원래는 score를 int로 받아야 하는데,
    // value 타입을 Integer로 했으니까 Integer로 하는게 더 나을 수도 있음

    // 1. void / 2. grade return
    public void saveScore(String subject, Integer score) {
        grade.put(subject, score);
    }

    public Map<String, Integer> saveGrade(String subject, Integer score) {
        grade.put(subject, score);
        return grade;
    }

    // void로 return 하면, 이렇게 getter가 있어야함
    public Map<String, Integer> getGrade() {
        return grade;
    }

    // /////////////////////////// 성적 평균 계산하기 ///////////////////////////

    public double scoreAverage() {

        Integer total = 0;

        for (String key : grade.keySet()) {
            total += grade.get(key);
        }

        return (double) total / grade.size();
    }

    // /////////////////////////// 학생 정보 조회하기 ///////////////////////////

    public void showInfo(){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("grade = " + grade);
    }

    // /////////////////////////// 학생 이름 getter ///////////////////////////

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
