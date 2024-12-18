package org.example.interfaceprac2;

public class Mage extends Character implements ManaUseable {

    private int mana;
    private static final int MAX_MANA = 100;

    public Mage(String name){
        super(name);
        this.maxHealth = 70;
        this.hp = 70;
        this.mana = 100;
    }

    @Override
    public void attack(Character otherSide) {
        // 마나 사용
        useMana();

        if (mana == 0){
            System.out.println("You cannot attack.");
            return;
        }

        // 상대방에게 데미지 주기
        otherSide.takeDamage();

        // 내가 누굴 공격했는지.
        System.out.println(this.name + " attacks " + otherSide.name + "!");
    }

    @Override
    public void takeDamage(){

        // 공격을 받으면 체력이 깎임
        hp -= 10;

        // 체력이 다 떨어지면 죽는다 . . .
        if (hp <= 0) {
            hp = 0;
            System.out.println("Died...");
            return;
        }

        System.out.println("Ouch!");

    }

    @Override
    public void levelUp() {
        super.levelUp();
        maxHealth += 15;
        mana = MAX_MANA;
        hp = maxHealth;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("mana: " + mana);
    }

    @Override
    public void useMana() {
        if (mana <= 0) {
            mana = 0;
            return;
        }

        mana -= 10;
    }
}
