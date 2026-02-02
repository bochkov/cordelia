package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class RsSessionStats extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {

        @JsonProperty("active_torrent_count")
        private Integer activeTorrentCount;

        @JsonProperty("download_speed")
        private Integer downloadSpeed;

        @JsonProperty("paused_torrent_count")
        private Integer pausedTorrentCount;

        @JsonProperty("torrent_count")
        private Integer torrentCount;

        @JsonProperty("upload_speed")
        private Integer uploadSpeed;

        @JsonProperty("cumulative_stats")
        private SessionStats cumulativeStats;

        @JsonProperty("current_stats")
        private SessionStats currentStats;
    }

    @Getter
    @Setter
    @ToString
    public static final class SessionStats {

        @JsonProperty("uploaded_bytes")
        private Long uploadedBytes;

        @JsonProperty("downloaded_bytes")
        private Long downloadedBytes;

        @JsonProperty("files_added")
        private Long filesAdded;

        @JsonProperty("seconds_active")
        private Long secondsActive;

        @JsonProperty("session_count")
        private Long sessionCount;

    }

}
