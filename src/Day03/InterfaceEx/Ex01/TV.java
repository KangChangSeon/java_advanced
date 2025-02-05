package Day03.InterfaceEx.Ex01;

public class TV implements RemoteControl {

    // 인터페이스에서 선언된 전원 on/off 하고 TV 스펙에 맞춰 구현
    @Override
    public void turnOn() {
        System.out.println("TV를 킵니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }
}
