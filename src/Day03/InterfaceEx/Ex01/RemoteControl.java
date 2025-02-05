package Day03.InterfaceEx.Ex01;

public interface RemoteControl {

    //가장 큰 볼륨을 저장할 멤버 30 할당
    public static final int MAX_VOLUME = 30;

    //가장 작은 볼륨을 저장할 멤버 0 할당
    public static final int MIN_VOLUME = 0;


    public void turnOn();
    public void turnOff();
    // 바디 {} 가 없으면 자동으로 추상 메서드(abstract) 처리

    public void setVolume(int volume); // 볼륨 세팅
    public void viewVolume();
}