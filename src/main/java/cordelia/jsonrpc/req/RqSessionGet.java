package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsSessionGet;
import lombok.Builder;

import java.util.List;

public final class RqSessionGet extends RpcRequest<RsSessionGet> {

    @JsonProperty
    private final Params params;

    public RqSessionGet(Long id, Params params) {
        super("session_get", id);
        this.params = params;
    }

    @Override
    public Class<RsSessionGet> responseClass() {
        return RsSessionGet.class;
    }

    @Builder
    public static final class Params {

        @JsonProperty
        private List<String> fields;

    }
}
