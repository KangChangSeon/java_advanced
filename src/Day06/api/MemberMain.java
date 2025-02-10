package Day06.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemberMain {
    public static void main(String[] args) {
        Member m1 = new Member("신세종");
        Member m2 = new Member("신세종");

        // 컴퓨터적인 관점
        System.out.println(m1==m2); // 주소 비교 false
        // 사용자적인 관점
        System.out.println(m1.equals(m2)); // Object equals() : 주소값을 비교하기 때문에 false

        // 객체 인스턴스마다 각기 다른 해시코드(주소) 값을 가지기 때문이다.
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());

        // 리스트를 생성하고 두 객체 데이터 추가
        List<Member> members = new ArrayList<>(); // 비교하지 않고 바로 집어넣음
//        ArrayList<Member> members1 = new ArrayList<>();
        members.add(m1);
        members.add(m2);
        System.out.println("현재 m 클라우드 집은 "+members.size()+"명의 회원이 존재합니다.");

        Set<Member> members1 = new HashSet<>(); // 이름(name)이 같을 경우 한명으로 처리하게 됨
        members1.add(m1);
        members1.add(m2);
        System.out.println(members1.size());
        // Collection(HashMap, HashSet, HasTable) 은 객체가 논리적으로 같은지를 비교할 때
        // hashcode() -검증 후-> equals()
    }
}