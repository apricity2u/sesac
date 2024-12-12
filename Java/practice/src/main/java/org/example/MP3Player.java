package org.example;

public class MP3Player {

    String model;
    int volume;
    boolean isOn;

    public MP3Player(String model) {
        this.model = model;
        this.volume = 0;
        this.isOn = false;
    }

    // 사용자들은 버튼을 눌러서 전원을 껐다 켰다 한다.
    // 현재 전원 상태에 따라서 껐다켜진다.
    // 결국 우리가 구현한 상황과 사용자들이 경험하는 것은 다르다.
    boolean pushPowerButton(){
        if (this.isOn) {
            return this.turnOff();
        } else {
            return this.turnOn();
        }
    }

    // 전원 켜기 / 전원을 키고, 볼륨을 40으로 설정 (최대 100)
    boolean turnOn(){
        this.volume = 40;
        this.isOn = true;

        // 실습 문제에서는 반드시 성공하지만.
        // 실제 서비스에서는 "전원 켜야지"라는 동작을 한다고 해서 켜진다는 보장이 없는 경우가 있기 때문에
        // 그런 경우에는 동작에 대해 성공하면 "성공"을 return, 실패하면 "실패"를 return하는 과정이
        // 자연스러울 수 있다.

//        if (성공) {
//            return true;
//        }else {
//            return false;
//        }

        return this.isOn;
    }

    // 전원 끄기 / 전원을 끄고, 볼륨을 0으로 설정 (최소 0)
    boolean turnOff(){
        this.volume = 0;
        this.isOn = false;
        return this.isOn;
    }

    // 볼륨 증가 - 볼륨 20 증가 (최대 100)
    int volumeUp(){

        // 꺼져있을 때는 0
        if(!isOn){
            return 0;
        }

        if (this.volume >= 100) {
            this.volume = 100;
        }

        this.volume += 20;

        return this.volume;
    }

    // 볼륨 감소 - 볼륨 20 감소 (최소 0)
    int volumeDown(){

        // 꺼져있을 때는 0
        if(!isOn){
            return 0;
        }

        if (this.volume <= 0) {
            this.volume = 0;
        }

        this.volume -= 20;

        return this.volume;
    }

    // 정보 조회
    void getInfo(){
        System.out.printf("model: %s, volume: %d, isOn: %b \n", model, volume, isOn);
    }


}
