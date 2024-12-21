package org.example.composition;

public abstract class Weapon implements SpecialAttackable {

    protected int power;
    protected int durability;

    public Weapon(int power, int durability) {
        this.power = power;
        this.durability = durability;
    }

    // 1. Weapon이 SpecialAttackable을 기본 null 값으로 가지고, 스페셜 공격을 하는 클래스만 override
    // 2. Weapon이 SpecialAttackable을 composition으로 가지기

    // 과연 SpecialAttackable 인터페이스를 따로 만드는게 맞았을까?

}
