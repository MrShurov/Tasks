package First;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class MyStreamAction<T> {
    private T bodyOfAction;
    private String type;
    private List myStreamContent;
}
