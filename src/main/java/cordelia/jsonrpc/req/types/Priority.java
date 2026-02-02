package cordelia.jsonrpc.req.types;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Priority {

    LOW(-1), NORMAL(0), HIGH(1);

    @JsonValue
    private final int weight;

}
