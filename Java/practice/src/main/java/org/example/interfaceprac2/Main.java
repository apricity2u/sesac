package org.example.interfaceprac2;

public class Main {
    public static void main(String[] args) {

        Bus bus = new Bus("bus");
        Vehicle bus2 = new Bus("bus2");
        // 이 경우, bus2라는 인스턴스는 Vehicle에 정의된 메서드의 종류만 사용이 가능함.
        // (bus에 implement한 인터페이스는 사용이 불가능!)
        // 대신, 실행을 할 때는 Bus에 정의된 메서드를 사용. (인스턴스의 것)
        // Vehicle한테 굳이 bus가 하는 무언가를 시키지는 않을 것.. 사실 고려조차 할 필요가 없다

        Truck truck = new Truck("truck");
        Brucks brucks = new Brucks("brucks");

        System.out.println(bus.chargeFuel(400));
        System.out.println(bus.getOn(10));
        System.out.println(bus.increaseSpeed(20));

        System.out.println(truck.chargeFuel(200));
        System.out.println(truck.loading(30));
        System.out.println(truck.increaseSpeed(20));

        System.out.println(brucks.chargeFuel(800));
        System.out.println(brucks.getOn(10));
        System.out.println(brucks.increaseSpeed(20));
        System.out.println(brucks.loading(30));
        System.out.println(brucks.increaseSpeed(20));
        System.out.println();

        // 캐릭터

        Character warrior = new Warrior("warrior");
        Character warrior2 = new Warrior("warrior2");

        warrior.attack(warrior2);



    }
}
