package Day03.InterfaceEx.Ex01;

public class Radio implements RemoteControl {

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("라디오를 킵니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("라디오를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.MAX_VOLUME){
            this.volume = RemoteControl.MAX_VOLUME;
            System.out.println("현재 해당 제품의 볼륨 최대값으로 셋팅 되었습니다.");
        }else if(volume < RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
            System.out.println("현재 해당 제품의 음소거(0)로 셋팅 되었습니다.");
        }else{
            this.volume = volume;
        }
        System.out.println("Radio 볼륨을 " + this.volume +"으로 설정하였습니다.");
    }

    @Override
    public void viewVolume() {
        System.out.println("현재 Radio 볼륨은 : " + this.volume);
    }
}
