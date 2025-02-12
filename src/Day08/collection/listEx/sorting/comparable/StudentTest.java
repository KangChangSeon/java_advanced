package Day08.collection.listEx.sorting.comparable;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        Student 철수 = new Student(250123,"김철수");
        Student 영희 = new Student(240867,"최영희");

        List<Student> list = new ArrayList<>();
        list.add(철수);
        list.add(영희);

        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
