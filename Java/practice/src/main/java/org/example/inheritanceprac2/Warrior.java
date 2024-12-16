package org.example.inheritanceprac2;

public class Warrior extends Character{

    // 분노게이지
    private int angerGauge;

    public Warrior(String name){
        super(name);
        this.angerGauge = 0;
        this.hp = 120;
    }

    // 레벨업 시 체력 30 증가
    @Override
    public int levelup(){
        hp += 30;
        return super.levelup();
    }

//    public int angerGaugeUp(){
//        angerGauge += 10;
//        return angerGauge;
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
        angerGauge += 10;
        // 분노게이지가 100이 되면 죽음...
        if (angerGauge == 100) {
            System.out.println(name + " is angry!");
            attack();
            angerGauge = 0;
            return;
        }

        // 공격 받을 때 0보다 작아지면 hp 0으로
        if (hp - 50 < 0){
            hp = 0;
            return;
        }
        hp -= 50;
    }

    // 분노게이지 조회 getter
    public int getAngerGauge() {
        return angerGauge;
    }
}
