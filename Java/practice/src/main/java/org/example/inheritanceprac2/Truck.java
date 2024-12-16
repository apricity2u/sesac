package org.example.inheritanceprac2;

public class Truck extends Vehicle{
    private int loadAmount;

    protected static final int MAX_FUEL = 250;

    public Truck(String model){
        super(model);
        this.loadAmount = 0;
    }

    public int loading(int load){
        loadAmount += load;
        return loadAmount;
    }

    public int unloading(int load){
        loadAmount -= load;
        return loadAmount;
    }

    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }

}
