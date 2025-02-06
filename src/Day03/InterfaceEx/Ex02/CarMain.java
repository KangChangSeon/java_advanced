package Day03.InterfaceEx.Ex02;
// 필드 다형성

import Day01.CarEx;
import Day01.HankookTire;
import Day01.Tire;

public class CarMain {
    public static void main(String[] args) {
        Car mycar = new Car();

        // 자동차에 타이어를 장착
        mycar.run();

        mycar.tire1 = new KumhoTire();
        mycar.tire2 = new KumhoTire();
        mycar.run();
    }
}
