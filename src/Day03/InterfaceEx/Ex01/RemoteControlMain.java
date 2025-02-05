package Day03.InterfaceEx.Ex01;

public interface RemoteControlMain {
    public static void main(String[] args) {

//        RemoteControl rc;
//        rc = new TV();     // 인터페이스 자신을 구현한 구현객체(TV)를 담을 수 있다
//        rc.turnOn();       // TV의 전원 ON
//        rc = new Radio();  // rc_ex 변수에 Radio 교체(대입) or 객체 참조
//        rc.turnOn();       // rc를 이용하여 라디오 전원 ON

        //상수는 구현 객체와 관련이 없는 인터페이스의 멤버이므로
        // 인터페이스로 바로 접근하여 상수값을 읽는다.
//        System.out.println("리모컨 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
//        System.out.println("리모컨 최소 볼륨 : " + RemoteControl.MIN_VOLUME);

        // 1. 리모컨을 구입한다.
        RemoteControl rc_ex;
        // 2. 새로 산 리모컨에 TV를 설정한다.
        rc_ex = new TV();
        // 3. 리모컨을 이용하여 TV를 켠다.
        rc_ex.turnOn();
        // 4. 리모컨을 이용하여 볼륨을 10으로 설정한다.
        rc_ex.setVolume(10);
        // 5. 리모컨을 이용하여 TV를 끈다.
        rc_ex.turnOff();

        // 1. 리모컨을 라디오로 페어링 한다.
        rc_ex = new Radio();
        //2. 리모컨을 이용하여 라디오를 켠다.
        rc_ex.turnOn();
        //3. 리모컨을 이용하여 볼륨을 20으로 설정하고 설정값을 확인한다.
        rc_ex.setVolume(20);
        rc_ex.viewVolume();
        //4. 리모컨을 이용하여 라디오를 끈다.
        rc_ex.turnOff();
    }
}