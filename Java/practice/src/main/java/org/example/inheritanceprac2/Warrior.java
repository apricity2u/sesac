package org.example.inheritanceprac2;

public class Warrior extends Character{

    // 분노게이지
    private int rage;
    private static final int MAX_RAGE = 100;

    public Warrior(String name){
        super(name);
        this.rage = 0;
        this.hp = 120;
        this.maxHp = 120;
    }

    // 레벨업 시 체력 30 증가
    @Override
    public int levelup(){
        super.levelup();
        maxHp += 30;
        hp += 30;
        return level;
    }

//    public int rageUp(){
//        rage += 10;
//        return rage;
//    }

    // 공격하기
    @Override
    public void attack(){
        System.out.println(name + " attack!");
    }

    // 공격당하기
    @Override
    public void attacked(){
        // hp = 0 이하면 죽었다...
        super.attacked();

        // 체력이 떨어져서 죽었으면.. 아래 코드 실행 X
        if (isDead) {
            return;
        }

        // 공격 받으면 분노게이지가 상승하고
        rage += 10;
        // 분노게이지가 100이 되면 죽음...
        if (rage == MAX_RAGE) {
            System.out.println(name + " is angry!");
            attack();
            rage = 0;
            return;
        }

        // 공격 받을 때 0보다 작아지면 hp 0으로
        if (hp - 50 < 0){
            hp = 0;
            super.attacked();
            return;
        }
        hp -= 50;
    }

    // rage 상승
    public void rageUp() {
        rage += 50;
        System.out.println("rage up!");
    }

    // 분노게이지 조회 getter
    public int getRage() {
        return rage;
    }
}
