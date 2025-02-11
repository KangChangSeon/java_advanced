package Day07.genericEx.Ex02;

public class StringProcessor implements Processor<String> {

    @Override
    public void process(String input) {
        System.out.println("Processing " + input);
    }
}
