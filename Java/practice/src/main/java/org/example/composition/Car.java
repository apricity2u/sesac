package org.example.composition;

public class Car implements Usable {

    private String model;
    private Engine engine; // 컴포지션
    private int speed;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.speed = 0;
    }

    public void accelerate(){
        if (engine.getHorsePower() > 10) {
            speed += engine.getHorsePower();
            System.out.println("accelerate!!!!!!");
        }else {
            System.out.println("......go slow......");
        }
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public void use() {
        accelerate();
    }
}
