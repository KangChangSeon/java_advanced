package Day01.abstractEx;

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("멍멍");
        // 추상 클래스의 부모를 갖은 자식 클래스에서는
        // 부모가 구현해 놓지 않은 추상메서드를 반드시 구현해야 한다
    }
}
