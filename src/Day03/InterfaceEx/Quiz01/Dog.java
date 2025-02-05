package Day03.InterfaceEx.Quiz01;

class Dog extends Animal {

    public Dog(int speed) {
        super(speed);
    }

    @Override
    public void run(int hours) {
        setDistance(getSpeed() * hours / 2.0);
    }
}

