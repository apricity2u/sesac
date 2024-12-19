package org.example.composition;

public class Character {

    private int health;
    private Weapon weapon;

    public Character(int health) {
        this.health = health;
    }

    public Character(int health, Weapon weapon) {
        this.health = health;
        this.weapon = weapon;
    }

    public void attack(){

        if (weapon == null) {
            System.out.println("basic attack!");
            return;
        }

        System.out.println("attack * " + weapon.power);
    }

    public void specialAttack(){

//        if (weapon instanceof SpecialAttackable){
//            ((SpecialAttackable) weapon).specialAttack();
//        }

        weapon.specialAttack();

    }

    public Weapon getWeaponStatus(){
       return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
        System.out.println("I have weapon! - " + weapon.power);
    }

}
