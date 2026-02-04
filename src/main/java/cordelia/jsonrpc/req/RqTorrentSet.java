package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.IdleLimit;
import cordelia.jsonrpc.req.types.Ids;
import cordelia.jsonrpc.req.types.Priority;
import cordelia.jsonrpc.req.types.RatioLimit;
import cordelia.jsonrpc.res.RsEmpty;
import cordelia.util.SplitSerializer;
import lombok.Builder;
import tools.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public final class RqTorrentSet extends RpcRequest<RsEmpty> {

    @JsonProperty
    private final Params params;

    public RqTorrentSet(Long id, Params params) {
        super("torrent_set", id);
        this.params = params;
    }

    @Override
    public Class<RsEmpty> responseClass() {
        return RsEmpty.class;
    }

    @Builder
    public static final class Params {

        /**
         * this torrent's bandwidth priority
         */
        @JsonProperty("bandwidth_priority")
        private Priority bandwidthPriority;

        /**
         * maximum download speed (kB/s)
         */
        @JsonProperty("download_limit")
        private Integer downloadLimit;

        /**
         * true if download_limit is honored
         */
        @JsonProperty("download_limited")
        private Boolean downloadLimited;

        /**
         * indices of file(s) to not download
         */
        @JsonProperty("files_unwanted")
        private List<Integer> filesUnwanted;

        /**
         * indices of file(s) to download
         */
        @JsonProperty("files_wanted")
        private List<Integer> filesWanted;

        /**
         * The name of this torrent's bandwidth group
         */
        @JsonProperty
        private String group;

        /**
         * true if session upload limits are honored
         */
        @JsonProperty("honors_session_limits")
        private Boolean honorsSessionLimits;

        /**
         * torrent list
         */
        @JsonUnwrapped
        private Ids ids;

        /**
         * array of string labels
         */
        @JsonProperty
        private List<String> labels;

        /**
         * new location of the torrent's content
         */
        @JsonProperty
        private String location;

        /**
         * maximum number of peers
         */
        @JsonProperty("peer_limit")
        private Integer peerLimit;

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
         * position of this torrent in its queue [0...n)
         */
        @JsonProperty("queue_position")
        private Integer queuePosition;

        /**
         * torrent-level number of minutes of seeding inactivity
         */
        @JsonProperty("seed_idle_limit")
        private Integer seedIdleLimit;

        /**
         * which seeding inactivity to use
         */
        @JsonProperty("seed_idle_mode")
        private IdleLimit seedIdleMode;

        /**
         * torrent-level seeding ratio
         */
        @JsonProperty("seed_ratio_limit")
        private Double seedRatioLimit;

        /**
         * which ratio to use
         */
        @JsonProperty("seed_ratio_mode")
        private RatioLimit seedRatioMode;

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

        /**
         * string of announce URLs, one per line, and a blank line between tiers.
         */
        @JsonProperty("tracker_list")
        @JsonSerialize(using = SplitSerializer.class)
        private List<String> trackerList;

        /**
         * maximum upload speed (kB/s)
         */
        @JsonProperty("upload_limit")
        private Integer uploadLimit;

        /**
         * true if upload_limit is honored
         */
        @JsonProperty("upload_limited")
        private Boolean uploadLimited;

    }
}
