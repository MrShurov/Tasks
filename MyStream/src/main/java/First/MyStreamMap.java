package First;

import java.util.List;

class MyStreamMap<T> extends MyStreamAction<T> {
    MyStreamMap(T bodyOfAction, List myStreamContent) {
        super(bodyOfAction, myStreamContent);
    }

    public MyStreamMap(T bodyOfAction) {
        super(bodyOfAction);
    }
}
