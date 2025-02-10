package Day06.api.lombokEx;

public class Main {
    public static void main(String[] args) {
        Member member = new Member();
        Member member1 = new Member("shin","sssq",24);
        System.out.println(member1.getId());
        member1.setId("sss");
        System.out.println(member1.toString());
    }
}
/*
shin
Member(id=sss, name=sssq, age=24)
 */