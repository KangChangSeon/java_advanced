package Day01.Ex02;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Bus bus = new Bus();
        driver.drive( bus );

        Taxi taxi = new Taxi();
        driver.drive( taxi );

        Horse horse = new Horse();
//        driver.drive( horse );
    }
}
