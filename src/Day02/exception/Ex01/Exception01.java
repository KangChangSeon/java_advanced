package Day02.exception.Ex01;

public class Exception01 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작\n");
        printLength("This is Java Programming");
        printLength(null);

        try {
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 종료\n");
    }

    public static void printLength(String data){
        int result = 0;
        try {
            result = data.length();
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 예외 정보를 얻는 방법 1
//            System.out.println(e.toString()); // 예외 정보를 얻는 방법 2
//            e.printStackTrace();              // 예외 정보를 얻는 방법 3
        } finally {
            System.out.println("마무리 실행\n");
        }
        System.out.println("문자의 수 : " + result);
    }
}
