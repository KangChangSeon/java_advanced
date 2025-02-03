package Day01.Ex01;

public class TVMain {
    public static void main(String[] args) {
        TV tv_remoteControl1 = new TV(); // 동일한 클래스 타입의 참조 변수를 생성해서 초기화
        TV tv_remoteControl2 = new SmartTV(); // 부모타입으로 자식 클래스 타입을 받아 초기화
        // TV 클래스 타입의 참조변수 tv_remoteControl2 를 선언하고, SmartTV 인스턴스를 생성하여,
        // 이 인스턴스의 주소값을 참조변수 tv_remoteControl2 에 대입한다.
        SmartTV smart_remoteControl = new SmartTV();

        TV tv = new TV();
        SmartTV smart_conrtol = (SmartTV) tv;
    }
}