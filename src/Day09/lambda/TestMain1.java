package Day09.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestMain1 {
    public static void main(String[] args) {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("Hello From a Thread");
            }
        };

        Runnable runnable1 = () -> System.out.println("Hello From a Runnable");
        runnable1.run();

        Function<String, Integer> stringLength = String::length;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "John");
        names.forEach(System.out::println);
        stringLength.apply("Alice");

        // 람다 표현식을 사용하여 "Hello Java"를 10번 출력하는 프로그램
        Runnable task1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello Java");
            }
        };
        Thread thread1 = new Thread(task1);


        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello Java");
            }
        };
        Thread thread2 = new Thread(task1);
        thread2.start();
        thread1.start();

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.stream().filter(num -> num % 2 == 1).forEach(System.out::println);
    }
}

