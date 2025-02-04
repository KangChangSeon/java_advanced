package Day02.exception.userDefineEx;

public class InsufficientEx extends Exception { // 일반 예외로 선언한 사용자 정의 예외 클래스

    public InsufficientEx() {}
    public InsufficientEx(String message) {
        super(message);
    }
}

