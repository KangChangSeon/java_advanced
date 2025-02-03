package Day01;

public class ChildEx {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.field1 = "xxx";
        parent.method1();
        parent.method2();
//        parent.field2 = "yyy";
//        parent.method3();

        Child child = (Child) parent;
        child.field2 = "yyy";
        child.method3();
    }
}
