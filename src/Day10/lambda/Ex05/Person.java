package Day10.lambda.Ex05;

public class Person {

    public void ordering(Comparable comparable) {
        String a = "홍길동";
        String b = "김길동";
        int result = comparable.compareTo(a,b);

        if (result < 0){
            System.out.println(a + "는 " + b + "보다 앞에 옵니다.");
        } else if (result == 0) {
            System.out.println(a + "와 " + b + "는 같습니다.");
        }else {
            System.out.println(a + "는 " + b + "보다 뒤에 옵니다.");
        }
    }
}
