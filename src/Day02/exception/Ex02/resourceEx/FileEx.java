package Day02.exception.Ex02.resourceEx;

import java.io.FileWriter;
import java.io.IOException;

public class FileEx {
    public static void main(String[] args) {

        FileWriter file1 = null;
        FileWriter file2 = null;

        try {
            file1 = new FileWriter("src/data1.txt");
            file2 = new FileWriter("src/data2.txt");
            file1.write("Java Advanced Programming 1");
            file2.write("Java Advanced Programming 2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                file1.close();
                file2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
