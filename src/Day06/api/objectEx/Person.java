package Day06.api.objectEx;

import lombok.Data;

// 데이터 전달을 위한 역할 : DTO (Data Transfer Object)
//                       반복적으로 사용되는 코드를 줄이기 위해 java14부터 record 도입
// 정보의 단위 : record, row(행)
@Data
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public String name(){return this.name;}
//    public int age(){return this.age;}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
