package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.Ids;
import cordelia.jsonrpc.res.RsEmpty;
import lombok.Builder;

public final class RqTorrentRemove extends RpcRequest<RsEmpty> {

    @JsonProperty
    private final Params params;

    public RqTorrentRemove(Long id, Params params) {
        super("torrent_remove", id);
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

        /**
         * delete local data. (default: false)
         */
        @JsonProperty("delete_local_data")
        private Boolean deleteLocalData;

    }

}
