package Day02.exception.Ex02.resourceEx;

public class MyResource implements AutoCloseable {

    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("[myResource] (" + name + ") 열기");
    }

    public String read1(){
        System.out.println("[myResource] (" + name + ") 읽기");
        return "200";
    }

    public String read2(){
        System.out.println("[myResource] (" + name + ") 읽기");
        return "abc";
    }

    @Override
    public void close() throws Exception {
        System.out.println("[myResource] (" + name + ") 닫기");
    }
}
