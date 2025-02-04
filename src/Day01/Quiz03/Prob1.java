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
//import java.util.HashMap;
//import java.util.Map;
//
//public class Prob1 {
//    public static void main(String[] args) {
//        Map<String, Wheeler> vehicles = new HashMap<>();
//
//        Wheeler truck = new Truck("트럭", 0, 4);
//        Wheeler bike = new Bike("자전거", 0, 2);
//
//        vehicles.put("truck", truck);
//        vehicles.put("bike", bike);
//
//        for (Map.Entry<String, Wheeler> entry : vehicles.entrySet()) {
//            Wheeler vehicle = entry.getValue();
//            System.out.println(vehicle.carName + " : " + "바퀴 " + vehicle.wheelNumber + "개입니다.");
//        }
//
//        vehicles.get("truck").speedUp(20);
//        vehicles.get("bike").speedUp(25);
//        vehicles.get("truck").speedDown(150);
//        vehicles.get("bike").speedDown(20);
//        vehicles.get("truck").stop();
//        vehicles.get("bike").stop();
//    }
//}