package innerClass.ex01;

public class ABMain {
    public static void main(String[] args) {
        //A객체 생성
        A a = new A();
        //B 객체 생성
        A.B b = a.new B();
    }
}
