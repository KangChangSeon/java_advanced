package workshop.service.exception;

public enum ErrorException {
    INVALID_TITLE(101, "제목은 한글, 영문, 숫자로 구성된 10자 이내여야 합니다."),
    INVALID_WRITER(102, "작성자는 한글, 영문으로 구성된 5자 이내여야 합니다."),
    INVALID_MENU(103, "잘못된 선택입니다. 다시 입력하세요."),
    INVALID_POST(104, "해당 게시물이 존재하지 않습니다.");

    private final String msg;
    private final int code;

    ErrorException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Error Code: " + code + " | Message: " + msg;
    }
}
