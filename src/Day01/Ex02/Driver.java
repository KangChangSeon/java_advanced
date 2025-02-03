package Day01.Ex02;

public class Driver {

    // 메소드 선언부에서 매개변수를 클래스 타입의 매개변수로 받음
    public void drive(Vehicle vehicle) {
//        Object obj = vehicle;
//        Vehicle v = (Vehicle) obj;
        if(vehicle instanceof Taxi || vehicle instanceof Bus) {
            vehicle.run();
        } else {
            System.out.println("자격이 해당하지 않습니다.");
        }
    }
}
