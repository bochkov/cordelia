package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsFreeSpace;
import lombok.Builder;

public final class RqFreeSpace extends RpcRequest<RsFreeSpace> {

    @JsonProperty
    private final Params params;

    public RqFreeSpace(Long id, Params params) {
        super("free_space", id);
        this.params = params;
    }

    @Override
    public Class<RsFreeSpace> responseClass() {
        return RsFreeSpace.class;
    }

    @Builder
    public static final class Params {

        /**
         * the directory to query
         */
        @JsonProperty
        private String path;

    }

}
