package workshop.service.exception;

public class CustomException extends RuntimeException{
    private final ErrorException errorException;

    public CustomException(ErrorException errorException){
        super(errorException.getMsg());
        this.errorException = errorException;
    }

    public ErrorException getErrorException(){
        return errorException;
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "errorException=" + errorException +
                '}';
    }
}
