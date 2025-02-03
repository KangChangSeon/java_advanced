package Day01.Quiz03;

public class Truck extends Wheeler{
    public Truck(String carName, int velocity) {
        super(carName, velocity);
    }

    public Truck(String carName, int velocity, int wheelNumber) {
        super(carName, velocity, wheelNumber);
    }

    @Override
    public void speedUp(int speed) {
        setVelocity(getVelocity() + speed*5);
        if(getVelocity() > 100){
            setVelocity(100);
            System.out.println("트럭의 최고속도위반으로 속도를 "+getVelocity()+" 으로 올립니다.");
        }
    }

    @Override
    public void speedDown(int speed) {
        setVelocity(getVelocity() - speed*5);
        if(getVelocity() < 50){
            setVelocity(50);
            System.out.println("트럭의 최저속도위반으로 속도를 "+getVelocity()+" 으로 올립니다.");
        }
    }
}
