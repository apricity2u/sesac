package org.example.inheritanceprac2;

public class Bus extends Vehicle{
    private int passengerCount;

    protected static final int MAX_FUEL = 300;

    public Bus(String model){
        super(model);
        this.passengerCount = 0;
    }

    public int getOnBus(int passenger){
        passengerCount += passenger;
        return passengerCount;
    }

    public int getOffBus(int passenger){
        passengerCount -= passenger;
        return passengerCount;
    }

    public int getPassengerCount(){
        return passengerCount;
    }

    @Override
    public int getMaxFuel() {
        return MAX_FUEL;
    }

}
