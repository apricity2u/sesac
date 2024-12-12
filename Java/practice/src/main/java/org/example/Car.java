package org.example;

public class Car {

    String model;
    int speed;

    public Car(String model){
        this.model = model;
        this.speed = 0;
    }

    // 입력 x / 속도를 높여줘 / return 속도 또는 X
    int increaseSpeed() {
        this.speed += 10;
        return this.speed;
    }

    int decreaseSpeed() {
        if (this.speed != 0) {
            this.speed -= 10;
        }
        return this.speed;
    }

    // 입력 X / 정보 보여주기 / return X
    void getInfo() {
        System.out.println("model: " + this.model + ", " + "speed: " + this.speed);
        // formatting
        System.out.printf("model: %s speed : %d \n", model, speed);
    }

    // 입력 : int / 속도 올리고 / return 속도
    int increaseSpeedByAmount(int amount) {
        this.speed += amount;
        return this.speed;
    }

}
