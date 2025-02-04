package Day02.exception.Ex02.resourceEx;

// AutoCloseable 인터페이스를 구현한 MyResource 리소스를 try-with-resources 블록에서 수행 후 처리
// try 블록에서 예외 발생 여부와 상관없이 안전하게 close() 메소드가 실행됨

public class TryWithResourceEx {

    public static void main(String[] args) {

        try (MyResource resource = new MyResource("A")){
            String data = resource.read1();
            int value = Integer.parseInt(data);
        } catch(Exception e){
            System.out.println("예외 처리 : " + e.getMessage());
        }

        System.out.println();

        try (MyResource resource = new MyResource("B")){
            String data = resource.read2();
            int value = Integer.parseInt(data);
        } catch(Exception e){
            System.out.println("예외 처리 : " + e.getMessage());
        }

        System.out.println();

        MyResource resource1 = new MyResource("A");
        MyResource resource2 = new MyResource("B");

        try (resource1; resource2){
            String data1 = resource1.read1();
            String data2 = resource2.read2();
        } catch (Exception e){
            System.out.println("try with resource : " + e.getMessage());
        }
    }
}
