package org.example.interfaceprac2;

public class Brucks extends Vehicle implements Rideable, Loadable{

    private int passengerCount;
    private int loadCount;
    private static final int MAX_FUEL = 1000;

    public Brucks(String model) {
        super(model);
        this.passengerCount = 0;
        this.loadCount = 0;
    }

    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }

    @Override
    public int loading(int amount) {
        loadCount += amount;
        return loadCount;
    }

    @Override
    public int unloading(int amount) {
        loadCount += amount;
        return loadCount;
    }

    @Override
    public int getOn(int amount) {
        passengerCount += amount;
        return passengerCount;
    }

    @Override
    public int getOff(int amount) {
        passengerCount += amount;
        return passengerCount;
    }
}
