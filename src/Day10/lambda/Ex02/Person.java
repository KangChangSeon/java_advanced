package Day10.lambda.Ex02;
//Person 클래스는 Workable을 매개변수로 갖는 action1(), speakable을 매개변수로 갖는 action2() 갖고 있다.

public class Person {
    private String name;
    private String job;
    private String contents;
    private String song;

    public Person(String name, String job, String contents, String song) {
        this.name = name;
        this.job = job;
        this.contents = contents;
        this.song = song;
    }

    public void action1(Workable workable){
        workable.work(name,job);
    }
    public void action2(Speakable speakable){
        speakable.speak(contents);
    }
    public void action3(Singable singable){
        singable.sing(song);
    }
}


// 홍길동 씨가  프로그래밍을 합니다.  출력
//"프로그래밍은 정말 재미있어!!"  말합니다. 출력