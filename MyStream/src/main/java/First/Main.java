package First;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(value -> value > 5).map(value -> value + " test").getResult().forEach(System.out::println);
    }
}
