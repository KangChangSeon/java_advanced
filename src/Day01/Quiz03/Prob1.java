package Day01.Quiz03;

public class Prob1 {
    public static void printWheel(Wheeler wheeler){
        if(wheeler instanceof Truck truck){
            System.out.println("트럭 : 바퀴 "+truck.getWheelNumber()+"개입니다.");
        }else if(wheeler instanceof Bike bike){
            System.out.println("자전거 : 바퀴 "+bike.getWheelNumber()+"개입니다.");
        }

    }
    public static void printVelocity(Wheeler wheeler) {
        if(wheeler instanceof Truck truck){
            System.out.println("트럭의 현재 속도는 " + truck.getVelocity() + " 입니다.");
        }else if(wheeler instanceof Bike bike){
            System.out.println("자전거의 현재 속도는 " + bike.getVelocity() + " 입니다.");
        }
    }
    public static void main(String[] args) {
        Truck truck = new Truck("트럭", 100, 4);
        Bike bike = new Bike("자전거", 25, 2);
        printWheel(truck);
        printWheel(bike);
        printVelocity(truck);
        printVelocity(bike);
        truck.speedDown(49);
        bike.speedDown(20);
        truck.stop();
        bike.stop();
        truck.speedUp(10);
        printVelocity(truck);
    }
}
