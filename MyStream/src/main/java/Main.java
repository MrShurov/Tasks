import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(value -> value > 5).filter(value -> value == 7).map(value -> value + " test").getMyStreamContent().forEach(System.out::println);
        new MyStream<>(Arrays.asList("Nick", "Fred")).filter(value -> value.equals("Fred")).map(value -> value + " test").getMyStreamContent().forEach(System.out::println);
    }
}
