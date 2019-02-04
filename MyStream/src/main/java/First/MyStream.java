package First;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
class MyStream<T> {

    private List<T> myStreamContent;
    private ArrayList<MyStreamAction> myStreamActions;

    MyStream(List<T> myStreamContent) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = new ArrayList<>();
    }

    private MyStream(List<T> myStreamContent, ArrayList<MyStreamAction> myStreamActions) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = myStreamActions;
    }

    MyStream<T> filter(Predicate<T> predicate) {
        myStreamActions.add(new MyStreamFilter<Predicate<T>>(predicate, myStreamContent));
        return new MyStream<T>(this.myStreamContent, this.myStreamActions);
    }

    <R> MyStream<T> map(Function<T, R> function) {
        myStreamActions.add(new MyStreamMap<Function<T, R>>(function, myStreamContent));
        return new MyStream<T>(this.myStreamContent, this.myStreamActions);
    }

    private MyStream<T> lazyFilter(Predicate<T> predicate) {
        List<T> newCollection = new ArrayList<>();
        for (T value : myStreamContent) {
            if (predicate.test(value)) {
                newCollection.add(value);
            }
        }
        return new MyStream<T>(newCollection);
    }

    private <R> MyStream<R> lazyMap(Function<T, R> function) {
        List<R> newCollection = new ArrayList<>();
        for (T value : myStreamContent) {
            newCollection.add(function.apply(value));
        }
        return new MyStream<R>(newCollection);
    }

    List<? super T> getResult() {
        MyStream stream = new MyStream<>(myStreamContent, myStreamActions);
        for (MyStreamAction myStreamAction : myStreamActions) {
            if (myStreamAction.getClass().equals(MyStreamFilter.class)) {
                stream = stream.lazyFilter((Predicate) myStreamAction.getBodyOfAction());
            } else if (myStreamAction.getClass().equals(MyStreamMap.class)) {
                stream = stream.lazyMap((Function) myStreamAction.getBodyOfAction());
            }
        }
        return stream.myStreamContent;
    }
}
