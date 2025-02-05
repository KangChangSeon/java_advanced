package Day03.InterfaceEx.Ex01;

public interface RemoteControlMain {
    public static void main(String[] args) {

        RemoteControl rc;
        rc = new TV();     // 인터페이스 자신을 구현한 구현객체(TV)를 담을 수 있다
        rc.turnOn();       // TV의 전원 ON
        rc = new Radio();  // rc 변수에 Radio 교체(대입) or 객체 참조
        rc.turnOn();       // rc를 이용하여 라디오 전원 ON

        //상수는 구현 객체와 관련이 없는 인터페이스의 멤버이므로
        // 인터페이스로 바로 접근하여 상수값을 읽는다.
        System.out.println("리모컨 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
        System.out.println("리모컨 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
    }
}