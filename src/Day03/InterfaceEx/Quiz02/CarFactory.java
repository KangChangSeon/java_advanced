package Day03.InterfaceEx.Quiz02;

public class CarFactory extends Factory {

    public CarFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    public int makeProducts(char skill) {
        return 0;
    }
}
