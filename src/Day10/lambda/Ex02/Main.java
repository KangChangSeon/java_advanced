package Day10.lambda.Ex02;

public class Main {
    public static void main(String[] args) {
        //황가람은 가수입니다. 출력
        //"저는 오랜 무명생활로 고생을 했답니다. 여러분 저를 사랑해주셔서 감사합니다." 출력
        //"반딧불" 노래를 부릅니다.
        Person person1 = new Person("황가람","가수","\"저는 오랜 무명생활로 고생을 했답니다. 여러분 저를 사랑해주셔서 감사합니다.\"","\"반딧불\"");
        person1.action1((name,job)-> System.out.println(name+"은 "+job+" 입니다."));
        person1.action2(content -> System.out.println(content + " 말합니다."));
        person1.action3(song -> System.out.println(song+" 노래를 부릅니다."));

        System.out.println();

        Person person2 = new Person("조수미","오페라가수","\"저를 오랫동안 사랑해주셔서 감사합니다.\"","\"밤의 아리아\"");
        person2.action1((name,job)-> System.out.println(name+"는 "+job+" 입니다."));
        person2.action2(content -> System.out.println(content + " 말합니다."));
        person2.action3(song -> System.out.println(song+" 노래를 부릅니다."));
    }
}
