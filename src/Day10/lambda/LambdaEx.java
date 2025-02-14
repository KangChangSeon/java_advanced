package Day10.lambda;

public class LambdaEx {
    public static void main(String[] args) {
        action((x, y) -> {
            int result = x+y;
            System.out.println("result1 = " + result);
                });

        action((x, y) -> {
            int result = x-y;
            System.out.println("result2 = " + result);
        });
    }
    public static void action(Calculable calculable) {
        int x = 10;
        int y = 20;
        calculable.calculate(x,y);
    }
}
