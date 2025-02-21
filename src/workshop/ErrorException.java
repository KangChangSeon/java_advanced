package workshop;

public enum ErrorException {
//    INVALID_TITLE("제목은 한글, 영문, 숫자로 구성된 10자 이내여야 합니다."),
//    INVALID_WRITER("작성자는 한글, 영문으로 구성된 5자 이내여야 합니다."),
//    INVALID_MENU("잘못된 선택입니다. 다시 입력하세요."),
    INVALID_POST("해당 게시물이 존재하지 않습니다.");

    private final String msg;
    ErrorException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
