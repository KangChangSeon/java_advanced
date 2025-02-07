package Day05.innerClass.ex04;

class A{

    static class B{}

        B field1 = new B();

        static B field2 = new B();

        A(){
            B b = new B();
        }

        void method1(){
            B b = new B();
        }

        static void method2(){
            B b = new B();
        }
    }


public class ABMain {
    public static void main(String[] args) {
        // 정적 멤버 클래스인 B 는 A.B() 로 직접 생성이 가능
        A.B b = new A.B();
    }
}
