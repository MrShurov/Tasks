package Second;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

    private final Consumer<Consumer<T>> myStreamAction;

    public MyStream(Consumer<Consumer<T>> myStreamAction) {
        this.myStreamAction = myStreamAction;
    }

    public void forEach(Consumer<T> action) {
        myStreamAction.accept(action);
    }

    public static <T> MyStream<T> of(Iterable<T> elements) {
        return new MyStream<T>(elements::forEach);
    }

    public static <T> MyStream<T> of(T[] elements) {
        return of(Arrays.asList(elements));
    }

    public <U> MyStream<U> map(Function<T, U> function) {
        System.out.println("map");
        return new MyStream<U>(action -> forEach(elements -> action.accept(function.apply(elements))));
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        System.out.println("filter");
        return new MyStream<T>(action -> forEach(elements -> {
            if(predicate.test(elements))
                action.accept(elements);
        }));
    }

    public void getResultInConsole() {
        forEach(System.out::println);
    }
}
