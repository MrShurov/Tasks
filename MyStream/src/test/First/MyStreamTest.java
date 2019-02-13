package First;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MyStreamTest {

    @Test
    public void filter() {
        assert (new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).getResult().equals(Arrays.asList(5, 6, 7, 8)));
    }

    @Test
    public void map() {
        assert (new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).map(e -> e + "Test").getResult().equals(Arrays.asList("1Test", "2Test", "3Test", "4Test", "5Test", "6Test", "7Test", "8Test")));
    }

    @Test
    public void getResult() {
        assert (new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).getResult().equals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));
    }

    @Test
    public void mapAndFilter(){
        System.out.println(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).map(e -> e + "Test").getResult());
        assert (new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).map(e -> e + "Test").getResult().equals(Arrays.asList("5Test","6Test","7Test","8Test")));
    }
}