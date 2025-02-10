package innerClass.ex01;

//인스턴스 멤버클래스 B 클래스
//B객체는 A클래스 내부 어디에서나 생성할 수 없고, 인스턴스 필드값, 생성자, 인스턴스 메소드에서 생성할 수 있다.
public class A {
    //인스턴스 멤버클래스
    class B {}

    //인스턴스 필드 값으로 B객체 생성 대입
    B field = new B();

    //생성자
    A(){
        B b = new B();
    }
    //인스턴스 메소드
    void method(){
        B b = new B();
    }

}
