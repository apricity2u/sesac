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

    // implement DamageTakable
    // public abstract void attack(DamageTakable otherSide);
    // 타입에 클래스 뿐 아니라 인터페이스도 들어갈 수 있다.
    // 해당 인터페이스를 물려받은 것들은 다 들어갈 수 있다.
    // 물론 이런 경우가 많아지면 추상 클래스로 만드는게 나을 수도 있다.
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
