package Day10.lambda.Ex04;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        // 누구나 사용가능한 컴퓨터
        person.action(Computer::staticMethod);
        person.action((x,y)->Computer.staticMethod(x,y));

        // 개인 컴퓨터
        Computer computer = new Computer();
        person.action(computer::instanceMethod);
        person.action((x,y)->computer.instanceMethod(x,y));
    }
}
