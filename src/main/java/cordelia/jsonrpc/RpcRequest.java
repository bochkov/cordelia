package cordelia.jsonrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RpcRequest<S extends RpcResponse> {

    @JsonProperty("jsonrpc")
    protected final String version = "2.0";

    @JsonProperty
    protected final String method;

    @JsonProperty
    protected final Long id;

    public abstract Class<S> responseClass();

}
