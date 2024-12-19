package org.example.composition;

public class Main {
    public static void main(String[] args) {

        // Person & Pencil
        Pencil yellow = new Pencil("yellow ");
        Pencil pink = new Pencil("pink");
        Person person = new Person("jun", yellow);

        Pencil blue = new Pencil("blue");

        Pencil[] pencils = {yellow, pink};
        Person lynda = new Person("lynda", pencils);
        lynda.writeMany();
        System.out.println();

        // Engine, Car
        Engine engine = new Engine(100);
        Car car = new Car("Avante", engine);
        car.accelerate();
        System.out.println();

        Person beemo = new Person("beemo", yellow);
        beemo.use();
        beemo.setTool(car);
        beemo.use();
        System.out.println(car.getSpeed());
        System.out.println();

        // Weapon, Character
        Gun gun = new Gun(100, 100);
        Sword sword = new Sword(200, 200);
        Character character1 = new Character(100);
        Character character2 = new Character(200, gun);
        Character character3 = new Character(300, sword);

        character1.attack();
        character1.setWeapon(gun);

        character2.attack();
        character2.setWeapon(sword);
        character2.specialAttack();

    }
}
