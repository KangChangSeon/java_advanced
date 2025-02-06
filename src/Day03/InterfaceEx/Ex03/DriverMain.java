package Day03.InterfaceEx.Ex03;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.drive();

        driver.vehicle1 = new Taxi();
        driver.drive();
    }
}
