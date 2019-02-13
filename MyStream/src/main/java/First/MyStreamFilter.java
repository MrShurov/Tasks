package First;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class MyStreamFilter<T> extends MyStreamAction<Predicate<T>> {

    MyStreamFilter(Predicate<T> bodyOfAction) {
        super(bodyOfAction);
    }

    MyStream<T> execute(List content){
        List<T> newCollection = new ArrayList<>();
        List<T> myStreamContent = (List<T>)content;
        for (T value : myStreamContent) {
            if (getBodyOfAction().test(value)) {
                newCollection.add(value);
            }
        }
        return new MyStream<T>(newCollection);
    }
}
