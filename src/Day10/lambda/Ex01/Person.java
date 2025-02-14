package Day10.lambda.Ex01;
// Person 클래스는 Workable을 매개변수로 갖는 action 메서드를 갖고 있다.
public class Person {
    public void action(Workable workable) {
        workable.work();
    }
}