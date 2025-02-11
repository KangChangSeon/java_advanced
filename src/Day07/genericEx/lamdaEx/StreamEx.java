package Day07.genericEx.lamdaEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "programming", "programming");

        List<String> filterWords = words.stream()
                .filter(word -> word.length() > 4)
                .map(word -> word.toUpperCase())
                .collect(Collectors.toUnmodifiableList());

        System.out.println(filterWords);
    }
}
