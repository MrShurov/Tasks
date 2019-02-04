package First;

import java.util.List;

class MyStreamFilter<T> extends MyStreamAction<T> {
    MyStreamFilter(T bodyOfAction, List myStreamContent) {
        super(bodyOfAction, myStreamContent);
    }

    MyStreamFilter(T bodyOfAction) {
        super(bodyOfAction);
    }
}
