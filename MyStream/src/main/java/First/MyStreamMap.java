package First;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class MyStreamMap<T, R> extends MyStreamAction<T> {

    MyStreamMap(T bodyOfAction) {
        super(bodyOfAction);
    }

    MyStream<R> execute(List<T> content) {
        List<R> newCollection = new ArrayList<>();
        Function<T,R> function = (Function<T,R>)getBodyOfAction();
        for (T value : content) {
            newCollection.add(function.apply(value));
        }
        return new MyStream<R>(newCollection);
    }
}
