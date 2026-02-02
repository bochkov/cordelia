package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.Ids;
import cordelia.jsonrpc.res.RsEmpty;
import lombok.Builder;

public final class RqTorrentMove extends RpcRequest<RsEmpty> {

    @JsonProperty
    private final Params params;

    public RqTorrentMove(Long id, Params params) {
        super("torrent_set_location", id);
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
        @JsonProperty
        private Ids ids;

        /**
         * the new torrent location
         */
        @JsonProperty
        private String location;

        /**
         * if true, move from previous location. otherwise, search location for files (default: false)
         */
        @JsonProperty
        private Boolean move;

    }
}
