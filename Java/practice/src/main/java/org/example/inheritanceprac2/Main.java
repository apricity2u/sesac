package org.example.inheritanceprac2;

public class Main {
    public static void main(String[] args) {

        // Animal 상속
        Animal animal = new Animal("bobbi", 3);
        animal.shoutOut();
        System.out.println(animal.getAge());

        Dog dog = new Dog("happy", 4, "puddle");
        dog.shoutOut();
        System.out.println(dog.getAge());

        Cat cat = new Cat("kitty", 2);
        cat.shoutOut();
        cat.purring();
        System.out.println(cat.getAge());




        System.out.println();
        // Vehicle 상속
        Vehicle vehicle = new Vehicle("vehicle");
        System.out.println(vehicle.speed);
        System.out.println(Vehicle.MAX_FUEL);
        vehicle.addFuel(200);
        System.out.println(vehicle.fuel);

        Bus bus = new Bus("bus");
        System.out.println(bus.fuel);
        bus.increaseSpeed(10);
        bus.getOnBus(12);
        bus.addFuel(400);
        System.out.println(bus.fuel);
        System.out.println(bus.getPassengerCount());

        Truck truck = new Truck("truck");
        System.out.println(truck.fuel);




        System.out.println();
        // Character 상속
        Character c = new Character("c");
        c.attack();
        c.levelup();

        // warrior 세팅
        Warrior warrior = new Warrior("warrior");
        System.out.println(warrior.level);
        System.out.println(warrior.hp);
        System.out.println(warrior.getRage());

        warrior.levelup();

        System.out.println(warrior.level);
        System.out.println(warrior.hp);

        System.out.println();

        // mage 세팅
        Mage m = new Mage("mage");
        System.out.println(m.level);
        System.out.println(m.hp);
        System.out.println(m.getMana());

        m.levelup();

        System.out.println(m.level);
        System.out.println(m.hp);

        System.out.println();

        // mage ---- attack ----> warrior
        m.attack();
        warrior.attacked();

        // warrior ---- attack ----> mage
        warrior.attack();
        m.attacked();

        m.attack();
        warrior.attacked();

        System.out.println();

        // 공격 주고 받고 현재 상태
        System.out.println(warrior.level);
        System.out.println(warrior.hp);
        System.out.println(warrior.getRage());
        System.out.println(m.level);
        System.out.println(m.hp);
        System.out.println(m.getMana());

    }
}
