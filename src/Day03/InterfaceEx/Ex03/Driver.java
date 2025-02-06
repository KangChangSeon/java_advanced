package Day03.InterfaceEx.Ex03;

public class Driver {

    // 메소드 선언부에서 매개변수를 클래스 타입의 매개변수로 받음
    Vehicle vehicle1 = new Bus();


    public void drive() {
        vehicle1.run();
    }
}
