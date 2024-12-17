package org.example.inheritanceprac2;

public class Mage extends Character{

    private int mana;
    private final int MAX_MANA = 100;

    public Mage(String name){
        super(name);
        this.hp = 70;
        this.mana = 100;
    }

    // 레벨업하면 체력 15 증가
    @Override
    public int levelup() {
        super.levelup();
        hp += 15;
        return level;
    }

    // 공격하기
    @Override
    public void attack(){

        // 마나가 떨어지면 공격할 수 없음
        if (mana < 10) {
            System.out.println("cannot use mana..");
            return;
        }

        // 공격하면 마나가 감소함
        mana -= 10;
        System.out.println("attack - use mana!");
    }

    // 공격당하기
    @Override
    public void attacked(){
        super.attacked();

        // 공격 받을 때 음수가 되면 hp 0으로 해!
        if (hp - 50 < 0){
            hp = 0;
            super.attacked();
            return;
        }

        hp -= 20;
    }

    // mana 조회하는 getter
    public int getMana() {
        return mana;
    }
}
