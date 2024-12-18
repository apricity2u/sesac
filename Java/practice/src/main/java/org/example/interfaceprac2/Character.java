package org.example.interfaceprac2;

public abstract class Character {

    protected String name;
    protected int level;
    protected int hp;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.hp = 100;
    }

    public abstract void attack(Character otherSide);

    public abstract void attacked();

}
