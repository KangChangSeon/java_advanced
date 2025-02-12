package Day08.collection.listEx.sorting.comparator;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나ㅏ이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
public class Main {
    public static void main(String[] args) {

        @Data
        class User {
            String name;
            int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        // List로 5명의 사용자 저장 후 정렬
        List<User> users = new ArrayList<User>();
        users.add(new User("홍길동", 32));
        users.add(new User("임준오", 48));
        users.add(new User("강창선", 31));
        users.add(new User("임성빈", 27));
        users.add(new User("김형태", 31));

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
//                return Integer.compare(o1.age, o2.age); // 나이순
                return o1.name.compareTo(o2.name); // 이름순
            }
        });

        // 정렬 리스트 출력
//        Collections.sort(users,(u1,u2) -> Integer.compare(u1.age, u2.age)); // 나이순 정렬
        Collections.sort(users, (u1,u2) -> u1.name.compareTo(u2.name)); // 이름순 정렬
        users.forEach(s -> System.out.println(s));

    }
}