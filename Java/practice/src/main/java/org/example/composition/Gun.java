package org.example.composition;

public class Gun extends Weapon{

    public Gun(int power, int durability) {
        super(power, durability);
    }

    @Override
    public void specialAttack() {
        System.out.println("special attack - gun");
    }
}
