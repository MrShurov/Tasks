package First;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class MyStream<T> {

    private List<T> myStreamContent;

    MyStream<T> filter(Predicate<T> predicate) {
        List<T> newCollection = new ArrayList<>();
        for (T value : myStreamContent) {
            if (predicate.test(value)) {
                newCollection.add(value);
            }
        }
        return new MyStream<T>(newCollection);
    }

    <R> MyStream<R> map(Function<T, R> function) {
        List<R> newCollection = new ArrayList<>();
        for (T value : myStreamContent) {
            newCollection.add(function.apply(value));
        }
        return new MyStream<R>(newCollection);
    }

    List<T> getResult(){
        return myStreamContent;
    }
}
