package First;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MyStreamTest {

    @Test
    public void filter() {
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).getResult())
                .isEqualTo(Arrays.asList(5, 6, 7, 8));

    }

    @Test
    public void map() {
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).map(e -> e + "Test").getResult())
                .isEqualTo(Arrays.asList("1Test", "2Test", "3Test", "4Test", "5Test", "6Test", "7Test", "8Test"));
    }

    @Test
    public void filterWithOutGetResult() {
        MyStream stream = new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4);
        assertThat(stream.getMyStreamContent())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

    }

    @Test
    public void mapWithOutGetResult() {
        MyStream stream = new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).map(e -> e + "Test");
        assertThat(stream.getMyStreamContent())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

    }

    @Test
    public void mapAfterFilter(){
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).map(e -> e + "Test").getResult())
                .isEqualTo(Arrays.asList("5Test","6Test","7Test","8Test"));
    }

    @Test
    public void filterAfterMap(){
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3)).map(e -> e + "Test").filter(line -> !"1Test".equals(line)).getResult())
                .isEqualTo(Arrays.asList("2Test","3Test"));
    }

    @Test
    public void emptyListGetResult(){
        assertThat(new MyStream<>(Arrays.asList()).getResult())
                .isEqualTo(Arrays.asList());
    }

    @Test
    public void emptyListFilter(){
        assertThat(new MyStream<>(Arrays.asList()).filter(e -> e.equals(4)).getResult())
                .isEqualTo(Arrays.asList());
    }

    @Test
    public void emptyListMap(){
        assertThat(new MyStream<>(Arrays.asList()).map(e -> e + "Test").getResult())
                .isEqualTo(Arrays.asList());
    }

    @Test
    public void twoFilterInARow(){
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).filter(e -> e < 7).getResult())
                .isEqualTo(Arrays.asList(5, 6));
    }

    @Test
    public void twoMapInARow(){
        assertThat(new MyStream<>(Arrays.asList(1, 2)).map(e -> e + "Test").map(e -> e + " Check").getResult())
                .isEqualTo(Arrays.asList("1Test Check", "2Test Check"));
    }

    @Test
    public void filterArrayFromString(){
        assertThat(new MyStream<>(Arrays.asList("Qwerty", "Poiu")).filter(e -> !e.equals("Qwerty")).getResult())
                .isEqualTo(Arrays.asList("Poiu"));
    }
}