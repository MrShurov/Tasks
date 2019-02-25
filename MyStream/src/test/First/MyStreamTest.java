package First;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MyStreamTest {

    @Test
    public void filterShouldReturnFilteredList() {
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).getResult())
                .isEqualTo(Arrays.asList(5, 6, 7, 8));

    }

    @Test
    public void mapShouldReturnMappedList() {
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).map(e -> e + "Test").getResult())
                .isEqualTo(Arrays.asList("1Test", "2Test", "3Test", "4Test", "5Test", "6Test", "7Test", "8Test"));
    }

    @Test
    public void filterWillNotWorkWithOutGetResult() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        MyStream stream = new MyStream<>(list).filter(e -> e > 4);
        assertThat(stream.getMyStreamContent())
                .isEqualTo(list);

    }

    @Test
    public void mapWillNotWorkWithOutGetResult() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        MyStream stream = new MyStream<>(list).map(e -> e + "Test");
        assertThat(stream.getMyStreamContent())
                .isEqualTo(list);

    }

    @Test
    public void mapShouldReturnMappedListAfterFilter(){
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).map(e -> e + "Test").getResult())
                .isEqualTo(Arrays.asList("5Test","6Test","7Test","8Test"));
    }

    @Test
    public void filterShouldReturnFilteredListAfterMap(){
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3)).map(e -> e + "Test").filter(line -> !"1Test".equals(line)).getResult())
                .isEqualTo(Arrays.asList("2Test","3Test"));
    }

    @Test
    public void getResultWithEmptyContentShouldReturnEmptyList(){
        List emptyList = Arrays.asList();
        assertThat(new MyStream<>(emptyList).getResult())
                .isEqualTo(emptyList);
    }

    @Test
    public void filterWithEmptyContentShouldReturnEmptyList(){
        List emptyList = Arrays.asList();
        assertThat(new MyStream<>(emptyList).filter(e -> e.equals(4)).getResult())
                .isEqualTo(emptyList);
    }

    @Test
    public void mapWithEmptyContentShouldReturnEmptyList(){
        List emptyList = Arrays.asList();
        assertThat(new MyStream<>(emptyList).map(e -> e + "Test").getResult())
                .isEqualTo(emptyList);
    }

    @Test
    public void twoFilterInARowShouldReturnTwiceFilteredList(){
        assertThat(new MyStream<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)).filter(e -> e > 4).filter(e -> e < 7).getResult())
                .isEqualTo(Arrays.asList(5, 6));
    }

    @Test
    public void twoMapInARowShouldReturnTwiceMappedList(){
        assertThat(new MyStream<>(Arrays.asList(1, 2)).map(e -> e + "Test").map(e -> e + " Check").getResult())
                .isEqualTo(Arrays.asList("1Test Check", "2Test Check"));
    }

    @Test
    public void filterArrayFromStringShouldReturnFilteredList(){
        assertThat(new MyStream<>(Arrays.asList("Qwerty", "Poiu")).filter(e -> !e.equals("Qwerty")).getResult())
                .isEqualTo(Arrays.asList("Poiu"));
    }
}