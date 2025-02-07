package Day04.Prob4;

public class Main {
    public static void action(A a){
        if(a instanceof C){
            ((C)a).method2();
        }
        else{
            a.method1();
        }
    }
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();

        action(a1);
        action(a2);

    }
}
