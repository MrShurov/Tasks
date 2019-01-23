package Second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) {
        MyStream myStream = MyStream.of(Arrays.asList(1, 2, 3, 4, 5)).filter(x -> x > 2).map(x -> x + 2);;
        System.out.println("NOT EXECUTED YET");
        myStream.getResultInConsole();
    }
}
