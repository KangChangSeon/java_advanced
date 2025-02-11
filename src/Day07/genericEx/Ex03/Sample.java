package Day07.genericEx.Ex03;

public class Sample {
    //제너릭 메소드
    public static <T> void printValue(T value){
        System.out.println(value);
    }

    public static void main(String[] args) {
        printValue("Hello World");
        printValue(12345);
    }
}
