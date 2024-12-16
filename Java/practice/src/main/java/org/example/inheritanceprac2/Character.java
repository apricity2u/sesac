package org.example.inheritanceprac2;

public class Character {
    protected String name;
    protected int level;
    protected int hp;
    protected boolean isDead;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.isDead = false;
    }

    // 공격하기
    public void attack(){
        System.out.println(name + " attack!");
    }

    // 공격당하기
    public void attacked(){

        // 체력이 0이 되면 죽어..
        if (hp <= 0) {
            isDead = true;
            System.out.println(name + " died...");
            return;
        }

        // 체력이 0이 아니면 공격 당함
        System.out.println(name + " attacked!");
    }

    // 레벨업하기
    public int levelup(){
        return ++level;
    }
}