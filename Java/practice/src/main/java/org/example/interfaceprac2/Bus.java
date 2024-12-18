package org.example.interfaceprac2;

public class Bus extends Vehicle implements Rideable{

    private int passengerCount;
    private static final int MAX_FUEL = 300;

    public Bus(String model) {
        super(model);
        this.passengerCount = 0;
    }

    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }

    @Override
    public int getOn(int amount) {
        passengerCount += amount;
        return passengerCount;
    }

    @Override
    public int getOff(int amount) {
        passengerCount -= amount;
        return passengerCount;
    }

}
