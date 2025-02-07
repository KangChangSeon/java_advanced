package Day05.innerClass.ex05;

import Day04.Prob4.B;

// 로컬 클래스는 생성자 와 메서드가 실행될 동안에만 객체를 생성
// 메서드에 로컬변수는를 로컬 클래스가 사용할 경우,
// 로컬변수는 final의 특성을 갖게 되므로 값을 읽을수만 있고 쓸수는 없도록 되어있다.
// 이유: 로컬 내부에서 값을 변경하지 못하도록 제한

class A {
    // 메서드
    void useB(int param) {

        // A 클래스의 useB()안에 정의 된 로컬 클래스 B

        int value = 1; // final int value = 1; 이라고 생각하면 됨(변경 x)

        class B {
            int field1 = 10;
            static int field2 = 20;

            public B() {
                System.out.println("B 생성자 실행");
            }

            void method1() {
                System.out.println("B method1 실행");
//                System.out.println("원본 field1 " + field1); // 읽기
//                field1 = 30;
//                System.out.println("수정 field1 " + field1); // 읽기
                System.out.println("param = " + param); // 읽기 o
                System.out.println("value = " + value); // 읽기 o
//                param = 10; // 쓰기 금지
//                value = 30;
            }

            void method2() {
                System.out.println("B static method2 실행");
            }
        }
        B b = new B();
        System.out.println(b.field1);
        b.method1();

        System.out.println(b.field2);
        b.method2();
    }

}


public class ABLocalMain {
    public static void main(String[] args) {
        A a = new A();
//        a.useB();
    }
}
