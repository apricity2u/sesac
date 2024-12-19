package org.example.composition;

public class Sword extends Weapon implements SpecialAttackable{

    public Sword(int power, int durability) {
        super(power, durability);
    }

    @Override
    public void specialAttack() {
        System.out.println("special attack - sword");
    }
}
