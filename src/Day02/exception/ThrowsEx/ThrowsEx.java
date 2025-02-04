package Day02.exception.ThrowsEx;

public class ThrowsEx {
    public static void main(String[] args) throws ClassNotFoundException {

//        try {
//            findClass();
//        } catch (ClassNotFoundException e) {
//            System.out.println("예외처리" + e.getMessage()); // 호출한 곳에서 예외 처리
//        }

        findClass();
    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
