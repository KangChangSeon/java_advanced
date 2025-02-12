package Day08.collection.listEx.sorting.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private int sno;
    private String name;


    @Override
    public int compareTo(Student o) {
        if (this.sno > o.sno) {
            return 1;
        } else if (this.sno == o.sno) {
            if (this.name.charAt(0) > o.name.charAt(0)) {
                return 1;
            } else if (this.name.charAt(0) < o.name.charAt(0)) {
                return -1;
            } else return -1;
        } else return -1;
//        return o.sno - this.sno;
    }
}
