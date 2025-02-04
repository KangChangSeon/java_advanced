package Day01.Quiz03;

public class Bike extends Wheeler{

    public Bike(String carName, int velocity) {
        super(carName, velocity);
    }

    public Bike(String carName, int velocity, int wheelNumber) {
        super(carName, velocity, wheelNumber);
    }

    @Override
    public void speedUp(int speed) {
        setVelocity(getVelocity() + speed);
        if(getVelocity() > 40){
            setVelocity(40);
            System.out.println("자전거의 최고속도위반으로 속도를 "+getVelocity()+" 으로 올립니다.");
        }
    }

    @Override
    public void speedDown(int speed) {
        setVelocity(getVelocity() - speed);
        if(getVelocity() < 10){
            setVelocity(10);
            System.out.println("자전거의 최저속도위반으로 속도를 "+getVelocity()+" 으로 올립니다.");
        }
    }
}
//public class Bike extends Wheeler{
//
//    public Bike(String carName, int velocity, int wheelNumber) {
//        this.carName = carName;
//        this.velocity = velocity;
//        this.wheelNumber = wheelNumber;
//    }
//
//    @Override
//    public void speedUp(int speed) {
//        velocity += speed;
//        if(velocity>40) {
//            velocity = 40;
//        }
//        System.out.println(carName +"의 현재 속도는 "+ velocity+"입니다.");
//    }
//
//    @Override
//    public void speedDown(int speed) {
//        velocity -= speed;
//        if(velocity<10) {
//            velocity = 10;
//            System.out.println(carName+ "최저속도위반으로 속도를 "+ velocity+"으로 올립니다.");
//        } else {
//            System.out.println(carName +"의 현재 속도는 "+ velocity+"입니다.");
//        }
//    }
//
//    @Override
//    public void wheelNumber() {
//        System.out.println(carName+" : " + "바퀴 "+ wheelNumber+ "개입니다.");
//    }
//}