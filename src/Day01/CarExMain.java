package Day01;
// 필드 다형성

public class CarExMain {
    public static void main(String[] args) {
        CarEx mycar = new CarEx();

        // 자동차에 타이어를 장착
        mycar.tire = new Tire();
        mycar.run();

        // HankookTire 교환
        mycar.tire = new HankookTire();
        mycar.run();

        // KumhoTire 교환
        mycar.tire = new KumhoTire();
        mycar.run();
    }
}
