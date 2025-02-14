package Day10.lambda.Ex02;
// String 컨텐츠를 제공을 하면 컨텐츠를 읽어주는 speak() 메서드를 가지고 있는 함수형 인터페이스입니다.
@FunctionalInterface
public interface Speakable {
    void speak(String contents);
}
