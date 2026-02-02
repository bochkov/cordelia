package cordelia.jsonrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public abstract class RpcResponse {

    @JsonProperty("jsonrpc")
    protected String version;

    @JsonProperty
    protected Long id;

    @JsonProperty
    protected RsError error;

    public boolean isError() {
        return error != null;
    }

    @Getter
    @Setter
    @ToString
    public static final class RsError {

        @JsonProperty
        private Integer code;

        @JsonProperty
        private String message;

        @JsonProperty
        private ErrorData data;

    }

    @Getter
    @Setter
    @ToString
    public static final class ErrorData {

        @JsonProperty("error_string")
        private String errorString;

        @JsonProperty
        private Map<String, Object> result;

    }

}
