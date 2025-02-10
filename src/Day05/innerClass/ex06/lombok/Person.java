package Day05.innerClass.ex06.lombok;


import lombok.*;

 //빌더메소드 생성
@NoArgsConstructor  //기본생성자
@AllArgsConstructor()  //모든 멤버를 적용한 생성자 오버로딩
@Data  //hashCode(), ToString(), Setter(),Getter()
public class Person {
    private String name;
    private String age;
    private String gender;
    private String job;
    private String address;
}
