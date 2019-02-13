package First;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
class MyStream<T> {

    private List<T> myStreamContent;
    private List<MyStreamAction> myStreamActions;

    MyStream(List<T> myStreamContent) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = new ArrayList<>();
    }

    private MyStream(List<T> myStreamContent, List<MyStreamAction> myStreamActions) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = myStreamActions;
    }

    MyStream<T> filter(Predicate<T> predicate) {
        myStreamActions.add(new MyStreamFilter<T>(predicate));
        return this;
    }

    <R> MyStream<T> map(Function<T, R> function) {
        myStreamActions.add(new MyStreamMap<T, R>(function));
        return this;
    }

    private MyStream<T> execute(Predicate<T> predicate) {
        List<T> newCollection = new ArrayList<>();
        for (T value : myStreamContent) {
            if (predicate.test(value)) {
                newCollection.add(value);
            }
        }
        return new MyStream<T>(newCollection);
    }

    private <R> MyStream<R> execute(Function<T, R> function) {
        List<R> newCollection = new ArrayList<>();
        for (T value : myStreamContent) {
            newCollection.add(function.apply(value));
        }
        return new MyStream<R>(newCollection);
    }

    List<? super T> getResult() {
        MyStream stream = new MyStream<>(myStreamContent, myStreamActions);
        for (MyStreamAction myStreamAction : myStreamActions) {
            stream = myStreamAction.execute(stream.myStreamContent);
        }
        return stream.myStreamContent;
    }
}
