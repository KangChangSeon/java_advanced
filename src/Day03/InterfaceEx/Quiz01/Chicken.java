package Day03.InterfaceEx.Quiz01;

class Chicken extends Animal implements Cheatable {

    public Chicken(int speed) {
        super(speed);
    }

    @Override
    public void run(int hours) {
        setDistance(getSpeed() * hours);
    }

    @Override
    public void fly() {
        setSpeed(getSpeed() * 2);
    }
}

