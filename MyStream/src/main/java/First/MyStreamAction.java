package First;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
class MyStreamAction<T> {
    private T bodyOfAction;
    private List myStreamContent;

    MyStreamAction(T bodyOfAction) {
        this.bodyOfAction = bodyOfAction;
    }
}
