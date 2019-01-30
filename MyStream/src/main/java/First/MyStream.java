package First;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

    private List<T> myStreamContent;
    private ArrayList<MyStreamAction> myStreamActions;

    public MyStream(List<T> myStreamContent) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = new ArrayList<>();
    }

    private MyStream(ArrayList<MyStreamAction> myStreamActions) {
        this.myStreamActions = myStreamActions;
    }

    MyStream<T> filter(Predicate<T> predicate) {
        myStreamActions.add(new MyStreamAction<Predicate<T>>(predicate, "filter", myStreamContent));
        return new MyStream<T>(this.myStreamActions);
    }

    <R> MyStream<R> map(Function<T, R> function) {
        myStreamActions.add(new MyStreamAction<Function<T, R>>(function, "map",myStreamContent));
        return new MyStream<R>(this.myStreamActions);
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
        MyStream stream = new MyStream<>(myStreamActions);
        stream.myStreamContent = myStreamActions.get(0).getMyStreamContent();
        for (MyStreamAction myStreamAction : myStreamActions) {
            if (myStreamAction.getType().equals("filter")) {
                stream = stream.lazyFilter((Predicate) myStreamAction.getBodyOfAction());
            } else if (myStreamAction.getType().equals("map")) {
                stream = stream.lazyMap((Function) myStreamAction.getBodyOfAction());
            }
        }
        return stream.myStreamContent;
    }
}
