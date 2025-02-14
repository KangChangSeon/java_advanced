package Day10.lambda.Ex03;

// Person 클래스는 Calculable 매개변수로 갖는 calculate 메서드를 갖고 있다.
// calculate 메서드는 Calculable 인터페이스를 매개변수로 갖는 메서드이다.

public class Person {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void action(Calculable calculable) {
        double result = calculable.calculate(this.x, this.y);
        System.out.println("결과 : " + result);
    }
}