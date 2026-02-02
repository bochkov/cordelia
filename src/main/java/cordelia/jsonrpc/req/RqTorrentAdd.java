package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.Priority;
import cordelia.jsonrpc.res.RsTorrentAdd;
import cordelia.util.Base64Serialize;
import cordelia.util.CookieSerializer;
import lombok.Builder;
import tools.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.Map;

public final class RqTorrentAdd extends RpcRequest<RsTorrentAdd> {

    @JsonProperty
    private final Params params;

    public RqTorrentAdd(Long id, Params params) {
        super("torrent_add", id);
        this.params = params;
    }

    @Override
    public Class<RsTorrentAdd> responseClass() {
        return RsTorrentAdd.class;
    }

    @Builder
    public static final class Params {

        /**
         * pointer to a string of one or more cookies.
         */
        @JsonProperty
        @JsonSerialize(using = CookieSerializer.class)
        private Map<String, String> cookies;

        /**
         * path to download the torrent to
         */
        @JsonProperty("download_dir")
        private String downloadDir;

        /**
         * filename or URL of the .torrent file
         */
        @JsonProperty
        private String filename;

        /**
         * array of string labels
         */
        @JsonProperty
        private List<String> labels;

        /**
         * .torrent content
         */
        @JsonProperty
        @JsonSerialize(using = Base64Serialize.class)
        private byte[] metainfo;

        /**
         * if true, don't start the torrent
         */
        @JsonProperty
        private Boolean paused;

        /**
         * maximum number of peers
         */
        @JsonProperty("peer_limit")
        private Integer peerLimit;

        /**
         * torrent's bandwidth priority
         */
        @JsonProperty("bandwidth_priority")
        private Priority bandwidthPriority;

        /**
         * indices of file(s) to download
         */
        @JsonProperty("files_wanted")
        private List<Integer> filesWanted;

        /**
         * indices of file(s) to not download
         */
        @JsonProperty("files_unwanted")
        private List<Integer> filesUnwanted;

        /**
         * indices of high-priority file(s)
         */
        @JsonProperty("priority_high")
        private List<Integer> priorityHigh;

        /**
         * indices of low-priority file(s)
         */
        @JsonProperty("priority_low")
        private List<Integer> priorityLow;

        /**
         * indices of normal-priority file(s)
         */
        @JsonProperty("priority_normal")
        private List<Integer> priorityNormal;

        /**
         * download torrent pieces sequentially
         */
        @JsonProperty("sequential_download")
        private Boolean sequentialDownload;

        /**
         * download from a specific piece when sequential download is enabled
         */
        @JsonProperty("sequential_download_from_piece")
        private Long sequentialDownloadFromPiece;

    }

}
