package Day07.genericEx.Ex04;

public class Applicant<T>{
    public T kind;

    public Applicant(T kind) {
        this.kind = kind;
    }
}
