package Day01;

class A{
    protected String field1;

    public A(){}

    protected void method1(){
        System.out.println("A클래스의 method1()");
    }
}

class B extends A{
    protected String field2;

    protected B(){}

    protected void method1(){
        System.out.println("B클래스의 method1()");
        A a = new A();
        a.field1 = "value1";
        a.method1();
    }
}



public class ProtectedMain {
}
