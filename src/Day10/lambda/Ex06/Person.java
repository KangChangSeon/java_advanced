package Day10.lambda.Ex06;

public class Person {
    public Member getMember1(Creatable1 creatable1) {
        String id = "ssg1";
        Member member1 = creatable1.create(id);
        return member1;
    }

    public Member getMember2(Creatable2 creatable2) {
        String id = "ssg1";
        String name = "신세계";
        Member member2 = creatable2.create(id,name);
        return member2;
    }
}
// 생성자 참조는 함수형 인터페이스의 매개변수 개수에 따라 실행되는 Member 생성자가 다름을 확인함