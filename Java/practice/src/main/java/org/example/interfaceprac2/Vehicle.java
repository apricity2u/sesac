package org.example.interfaceprac2;

public abstract class Vehicle {

    private String model;
    private int speed;
    private int fuel;
    protected static final int MAX_FUEL = 100;

    public Vehicle(String model) {
        this.model = model;
        this.speed = 0;
        this.fuel = 0;
    }

//    // 연료 관련
//    abstract void chargeFuel();
//
//    // 속도 관련
//    abstract void increaseSpeed();
//    abstract void decreaseSpeed();

    public int increaseSpeed(int amount){
        if (fuel >= amount) {
            speed += amount;
            fuel -= amount;
        }
        return speed;
    }

    public int decreaseSpeed(int amount){
        if (speed <=0) {
            return speed;
        }

        speed -= amount;
        return speed;
    }

    public int chargeFuel(int amount){
        if (amount >= getMaxFuel()){
            fuel = getMaxFuel();
            return fuel;
        }

        fuel += amount;
        return fuel;
    }

    public abstract int getMaxFuel();
}
