package First;

import java.util.function.Predicate;

class MyStreamFilter<T> extends MyStreamAction<T> {

    MyStreamFilter(T bodyOfAction) {
        super(bodyOfAction);
    }

    T execute(T object) {
        Predicate<T> predicate = (Predicate<T>) getBodyOfAction();
        if (predicate.test(object)) {
            return object;
        }
        return null;
    }
}
