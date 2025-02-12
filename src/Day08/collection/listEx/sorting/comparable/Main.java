package Day08.collection.listEx.sorting.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//사용자(User) 이름과 나이로 5명(객체)를 생성하고 나이순으로 정렬 한 후  사용자의 이름과 나ㅏ이를 출력하시오
//ex) 홍길동 32세
//    임준오 48세
public class Main {
    public static void main(String[] args) {

        @Data
        @AllArgsConstructor
        class User implements Comparable<User>{
            String name;
            int age;

            @Override
            public int compareTo(User o) {
                // 나이순으로 오름차순 / 나이가 같으면 이름으로 오름차순
                if(this.age > o.age) return 1;
                else if(this.age == o.age){
                    if(this.name.charAt(0) > o.name.charAt(0)){
                        return 1;
                    }else if(this.name.charAt(0) < o.name.charAt(0)){
                        return -1;
                    }else return 0;
                }
                else return -1;

//                // 이름순으로 오름차순
//                if(this.name.charAt(0) > o.name.charAt(0)) return 1;
//                else if(this.name.charAt(0) < o.name.charAt(0)) return -1;
//                else return 0;
            }
        }

        // List로 5명의 사용자 저장 후 정렬
        List<User> users = new ArrayList<User>();
        users.add(new User("홍길동",32));
        users.add(new User("임준오",48));
        users.add(new User("강창선",31));
        users.add(new User("임성빈",27));
        users.add(new User("김형태",31));


        // 정렬 리스트 출력
        Collections.sort(users);
        users.forEach(System.out::println);
    }
}