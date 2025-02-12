package Day08.collection.listEx.sorting.comparator;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나ㅏ이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
public class Main1 {
    public static void main(String[] args) {

        @ToString
        class User {
            private String name;
            private int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        // List로 5명의 사용자 저장 후 정렬
        List<User> users = new ArrayList<User>();
        users.add(new User("홍길동", 32));
        users.add(new User("임준오", 48));
        users.add(new User("강창선", 31));
        users.add(new User("임성빈", 27));
        users.add(new User("김형태", 31));

        Collections.sort(users, Comparator.comparing(User::getAge)); // 나이순 정렬
        users.forEach(s -> System.out.println(s));

        System.out.println("====================================");

        Collections.sort(users, Comparator.comparing(User::getName)); // 이름순 정렬
        users.forEach(s -> System.out.println(s));

        System.out.println("====================================");

        // 나이순으로 정렬 한 뒤에 이름순으로 정렬
        Collections.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName));
        users.forEach(s -> System.out.println(s));
    }
}