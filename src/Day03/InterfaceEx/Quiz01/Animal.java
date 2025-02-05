package Day03.InterfaceEx.Quiz01;

abstract class Animal {
    private int speed;
    private double distance;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Animal(int speed) {
        this.speed = speed;
    }

    public abstract void run(int hours);

    public double getDistance() {
        return distance;
    }
}
