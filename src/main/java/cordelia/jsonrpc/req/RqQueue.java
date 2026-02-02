package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.Ids;
import cordelia.jsonrpc.res.RsEmpty;
import lombok.Builder;

public abstract class RqQueue extends RpcRequest<RsEmpty> {

    @JsonProperty
    protected final Params params;

    public RqQueue(String method, Long id, Params params) {
        super(method, id);
        this.params = params;
    }

    @Builder
    public static final class Params {

        /**
         * torrent list
         */
        @JsonProperty
        private Ids ids;
    }
}
