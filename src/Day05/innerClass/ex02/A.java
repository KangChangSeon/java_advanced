package innerClass.ex02;

//인스턴스 멤버클래스 B 클래스
//B객체는 A클래스 내부 어디에서나 생성할 수 없고, 인스턴스 필드값, 생성자, 인스턴스 메소드에서 생성할 수 있다.
public class A {
    //인스턴스 멤버클래스
    class B {
        //인스턴스필드 
        int field1 = 10;
        static  int field2 = 20;
        //생성자
        B(){
            System.out.println("B의 생성자 실행");
        }
        //인스턴스 메소드
        void method1(){
            System.out.println("B의 method1 실행");
        }
        
        static void method2(){
            System.out.println("B의 static method2 실행");
        }

    }

    //인스턴스 메소드
    void useB(){
        B b = new B();
        System.out.println(b.field1);
        b.method1();

        System.out.println("B의 정적 필드와 정적 메소드");
        System.out.println(B.field2);
        B.method2();

    }

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
