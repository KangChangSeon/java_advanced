package Day10.lambda.Ex06;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        Member m1 = person.getMember1(Member::new);
        System.out.println(m1);
        Member m2 = person.getMember2(Member::new);
        System.out.println(m2);
    }
}
