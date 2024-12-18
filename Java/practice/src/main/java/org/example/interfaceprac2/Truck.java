package org.example.interfaceprac2;

public class Truck extends Vehicle implements Loadable{

    private int loadCount;
    private static final int MAX_FUEL = 250;

    public Truck(String model) {
        super(model);
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
        loadCount -= amount;
        return loadCount;
    }
}
