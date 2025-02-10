package Day06.api.objectEx;

import java.util.Objects;

public class Member extends Object {
    //    String id;
    String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) { // Object의 equals()( 메서드 재정의
//        if (obj instanceof Member target) { // obj Member 타입인지 검사하고 타입변환 후 target 변수에 대입
//            if (name.equals(target.name)) { // name 문자열이 같은지 비교하고 같으면 true 리턴
//                return true;
//            }
//        }
//        return false; // 같지 않으면 false 리턴
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return true;
        Member member = (Member) obj;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // name 필드의 해시코드를 반환한다.
    }
}
