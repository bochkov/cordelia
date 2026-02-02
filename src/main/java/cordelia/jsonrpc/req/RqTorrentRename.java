package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.Ids;
import cordelia.jsonrpc.res.RsTorrentRename;
import lombok.Builder;

public final class RqTorrentRename extends RpcRequest<RsTorrentRename> {

    @JsonProperty
    private final Params params;

    public RqTorrentRename(Long id, Params params) {
        super("torrent_rename_path", id);
        this.params = params;
    }

    @Builder
    public static final class Params {

        /**
         * the torrent list
         */
        @JsonProperty
        private Ids ids;

        /**
         * the path to the file or folder that will be renamed
         */
        @JsonProperty
        private String path;

        /**
         * the file or folder's new name
         */
        @JsonProperty
        private String name;
    }
}
