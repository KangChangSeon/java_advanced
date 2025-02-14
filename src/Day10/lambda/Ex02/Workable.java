package Day10.lambda.Ex02;
//Workable 인터페이스는 함수형 인터페이스이며 반환값이 없는
//work() 이름과 직무명을 갖는 단일 추상 메서드를 가지고 있습니다.
@FunctionalInterface
public interface Workable {
    public void work(String name, String job);
}