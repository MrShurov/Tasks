package First;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class MyStreamFilter<T> extends MyStreamAction<T> {

    MyStreamFilter(T bodyOfAction) {
        super(bodyOfAction);
    }

    MyStream<T> execute(List<T> content){
        List<T> newCollection = new ArrayList<>();
        Predicate<T> predicate = (Predicate<T>)getBodyOfAction();
        for (T value : content) {
            if (predicate.test(value)) {
                newCollection.add(value);
            }
        }
        return new MyStream<T>(newCollection);
    }
}
