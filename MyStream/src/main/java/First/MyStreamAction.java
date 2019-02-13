package First;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
abstract class MyStreamAction<T> {
    private T bodyOfAction;

    MyStreamAction(T bodyOfAction) {
        this.bodyOfAction = bodyOfAction;
    }

    abstract MyStream execute(List object);
}
