package First;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class MyStreamMap<T, R> extends MyStreamAction<Function<T,R>> {

    MyStreamMap(Function<T, R> bodyOfAction) {
        super(bodyOfAction);
    }

    MyStream<R> execute(List content) {
        List<R> newCollection = new ArrayList<>();
        List<T> myStreamContent = (List<T>)content;
        Function<T,R> function = (Function<T,R>)getBodyOfAction();
        for (T value : myStreamContent) {
            newCollection.add(function.apply(value));
        }
        return new MyStream<R>(newCollection);
    }
}
