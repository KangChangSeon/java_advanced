package Day02.exception.Ex02.resourceEx;

import java.io.*;

public class FileTryWithResourceEx {
    public static void main(String[] args) {

//        FileWriter file = null;

//        try {
//            file = new FileWriter("src/data.txt");
//            file.write("Java Advanced Programming 1");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                file.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        try(FileWriter file = new FileWriter("src/data.txt")){
            file.write("Java Programming");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try-with-resources 문의 괄호 () 객체를 생성하는 문장을 넣으면
        // 따로 close() 를 호출하지 않아도 try 블럭을 벗어나는 순간 자동적으로 close() 가 호출된다.
        // 다음에 catch 블럭 또는 finally 블럭이 수행 된다.

//        try(
//        FileInputStream fis = new FileInputStream("src/data.txt");
//        DataInputStream dis = new DataInputStream(fis);
//        ){
//            while(true){
//                String data = dis.readUTF();
//                System.out.println(data);
//            }
//        } catch (EOFException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (BufferedReader br = new BufferedReader(new FileReader("src/data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
