package First;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class MyStream<T> {

    private List<T> myStreamContent;
    private List<MyStreamAction> myStreamActions;

    List<T> getMyStreamContent() {
        return myStreamContent;
    }

    List<MyStreamAction> getMyStreamActions() {
        return myStreamActions;
    }

    MyStream(List<T> myStreamContent) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = new ArrayList<>();
    }

    private MyStream(List<T> myStreamContent, List<MyStreamAction> myStreamActions) {
        this.myStreamContent = myStreamContent;
        this.myStreamActions = myStreamActions;
    }

    MyStream<T> filter(Predicate<T> predicate) {
        myStreamActions.add(new MyStreamFilter<>(predicate));
        return this;
    }

    <R> MyStream<? super T> map(Function<T, R> function) {
        myStreamActions.add(new MyStreamMap<>(function));
        return this;
    }

    List<? super T> getResult() {
        MyStream stream = new MyStream<>(myStreamContent, myStreamActions);
        for (MyStreamAction myStreamAction : myStreamActions) {
            stream = myStreamAction.execute(stream.myStreamContent);
        }
        return stream.myStreamContent;
    }
}
