package Day03.InterfaceEx.Ex02;

public class Car {

    Tire tire1 = new HankookTire();
    Tire tire2 = new HankookTire();


    public void run() {
        tire1.roll();
        tire2.roll();
        // 인터페이스에 선언된 추상 메서드를 호출했다. 구현 객체의 roll 메서드를 설정
    }



}
