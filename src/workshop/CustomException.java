package workshop;

public class CustomException extends RuntimeException{
    private final ErrorException errorException;

    public CustomException(ErrorException errorException){
        super(errorException.getMsg());
        this.errorException = errorException;
    }

    public ErrorException getError(){
        return errorException;
    }
}
