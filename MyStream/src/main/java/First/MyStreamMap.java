package First;

import sun.misc.Unsafe;

import java.util.function.Function;

class MyStreamMap<T, R> extends MyStreamAction<T> {

    MyStreamMap(T bodyOfAction) {
        super(bodyOfAction);
    }

    Object execute(T object) {
        Function<T,R> function = (Function<T,R>)getBodyOfAction();
        return function.apply(object);
    }
}
