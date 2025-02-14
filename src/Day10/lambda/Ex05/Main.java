package Day10.lambda.Ex05;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.ordering(String::compareToIgnoreCase);
//        person.ordering((a,b)-> a.compareToIgnoreCase(b));
    }
}