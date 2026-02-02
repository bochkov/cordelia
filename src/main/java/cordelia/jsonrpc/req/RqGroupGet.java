package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsGroupGet;
import lombok.Builder;

import java.util.List;

public final class RqGroupGet extends RpcRequest<RsGroupGet> {

    @JsonProperty
    private final Params params;

    public RqGroupGet(Long id, Params params) {
        super("group_get", id);
        this.params = params;
    }

    @Override
    public Class<RsGroupGet> responseClass() {
        return RsGroupGet.class;
    }

    @Builder
    public static final class Params {

        /**
         * A list of bandwidth group description objects
         */
        @JsonProperty
        private List<String> group;

    }
}
