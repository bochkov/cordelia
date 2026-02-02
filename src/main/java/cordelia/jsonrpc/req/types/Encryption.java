package cordelia.jsonrpc.req.types;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Encryption {

    REQUIRED("required"),
    PREFERRED("preferred"),
    ALLOWED("allowed");

    @JsonValue
    private final String value;
}
