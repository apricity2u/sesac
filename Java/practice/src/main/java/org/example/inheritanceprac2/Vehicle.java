package org.example.inheritanceprac2;

public class Vehicle {
    protected String model;
    protected int speed;
    protected int fuel;

    // 최대연료량
    // 내 최대연료량은 아무도 안 건들게 상수로..!
    protected static final int MAX_FUEL = 100;

    public Vehicle(String model) {
        this.model = model;
        this.speed = 0;
        this.fuel = 0;
    }

    public int increaseSpeed(int amount){
        if (amount <= fuel) {
            speed += amount;
            fuel -= amount;
        }
        return speed;
    }

    public int decreaseSpeed(int amount){

        if (amount <= 0){
            return 0;
        }

        speed -= amount;
        return speed;
    }

    public int addFuel(int amount){
        fuel += amount;

        // 이건 부모의 MAX_FUEL을 가져오는 것.
        // 부모는 자기 자식을 알지 못하기 때문.
        /*
        if (fuel > MAX_FUEL) {
            fuel = MAX_FUEL;
        }
        */

        // 동적 바인딩
        if (fuel > getMaxFuel()){
            fuel = getMaxFuel();
        }

        return fuel;
    }

    public int getMaxFuel() {
        return MAX_FUEL;
    }
}
