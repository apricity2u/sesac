package org.example.interfaceprac2;

public class Warrior extends Character implements RageUseable {

    private int rage;
    private static final int MAX_RAGE = 100;

    public Warrior(String name){
        super(name);
        this.maxHealth = 120;
        this.hp = 120;
        this.rage = 0;
    }

    @Override
    public void attack(Character otherSide) {

        otherSide.takeDamage();

        // 내가 누굴 공격했는지.
        System.out.println(this.name + " attacks " + otherSide.name + "!");
    }

    @Override
    public void takeDamage(){

        // 공격을 받으면 체력이 깎임
        hp -= 20;

        // 체력이 다 떨어지면 죽는다 . . .
        if (hp <= 0) {
            hp = 0;
            System.out.println("Died...");
            return;
        }

        // 공격을 받으면 분노가 오른다.
        increaseRage();

        System.out.println("Ouch!");

    }

    @Override
    public void levelUp() {
        super.levelUp();
        maxHealth += 30;
        hp = maxHealth;
    }

    @Override
    public void increaseRage() {
        // 분노가 10씩 차오른다
        rage += 10;

        // 분노치가 최대를 찍으면 공격!
        // rage = Math.min(maxRage, rage + 10);
        if (rage >= MAX_RAGE){
            rage = MAX_RAGE;
            rageAttack();
        }

        System.out.println("I'm angry! My rage is " + rage);
    }

    @Override
    public void rageAttack() {
        // 분노가 가득 찼을 때 공격!
        System.out.println("rage attack!");
        rage = 0;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("rage: " + rage);
    }
}
