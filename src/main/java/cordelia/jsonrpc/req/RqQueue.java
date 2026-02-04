package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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

    @Override
    public Class<RsEmpty> responseClass() {
        return RsEmpty.class;
    }

    @Builder
    public static final class Params {

        /**
         * torrent list
         */
        @JsonUnwrapped
        private Ids ids;
    }
}
