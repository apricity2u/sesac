package org.example.interfaceprac2;

public abstract class Character {

    protected String name;
    protected int level;
    protected int hp;
    protected int maxHealth;

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }

    public abstract void attack(Character otherSide);

    public abstract void takeDamage();

    public void levelUp(){
        ++level;
        System.out.println("level up!");
    };

    public void showInfo(){
        System.out.println("hp: " + hp);
        System.out.println("level: " + level);
    }
}
