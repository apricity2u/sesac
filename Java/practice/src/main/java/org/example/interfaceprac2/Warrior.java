package org.example.interfaceprac2;

public class Warrior extends Character implements Rageable{

    private int rage;
    private static final int MAX_RAGE = 100;

    public Warrior(String name){
        super(name);
        this.hp = 120;
    }

    @Override
    public void attack(Character otherSide) {


        System.out.println(this.name + " attacks " + otherSide.name + "!");
    }

    @Override
    public void attacked(){

        increaseRage();

        if (hp <= 0) {
            System.out.println("Died...");
            return;
        }

        hp -= 20;
        System.out.println("Ouch!");

    }

    @Override
    public int increaseRage() {
        if (rage >= 100){
            return MAX_RAGE;
        }

        rage += 10;
        return rage;
    }
}
