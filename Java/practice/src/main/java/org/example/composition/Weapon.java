package org.example.composition;

public abstract class Weapon implements SpecialAttackable {

    protected int power;
    protected int durability;

    public Weapon(int power, int durability) {
        this.power = power;
        this.durability = durability;
    }


}
