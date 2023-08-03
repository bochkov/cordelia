package cordelia.rpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.rpc.types.Encryption;
import lombok.Builder;

@Builder
@ReqMethod(value = "session-set")
public final class RqSessionSet implements RqArguments {

    @JsonProperty("alt-speed-down")
    private Long altSpeedDown;

    @JsonProperty("alt-speed-enabled")
    private Boolean altSpeedEnabled;

    @JsonProperty("alt-speed-time-begin")
    private Integer altSpeedTimeBegin;

    @JsonProperty("alt-speed-time-day")
    private Integer altSpeedTimeDay;

    @JsonProperty("alt-speed-time-enabled")
    private Boolean altSpeedTimeEnabled;

    @JsonProperty("alt-speed-time-end")
    private Integer altSpeedTimeEnd;

    @JsonProperty("alt-speed-up")
    private Long altSpeedUp;

    @JsonProperty("blocklist-enabled")
    private Boolean blocklistEnabled;

    @JsonProperty("blocklist-url")
    private String blocklistUrl;

    @JsonProperty("cache-size-mb")
    private Integer cacheSize;

    @JsonProperty("default-trackers")
    private String defaultTrackers;

    @JsonProperty("dht-enabled")
    private Boolean dhtEnabled;

    @JsonProperty("download-dir")
    private String downloadDir;

    @JsonProperty("download-queue-enabled")
    private Boolean downloadQueueEnabled;

    @JsonProperty("download-queue-size")
    private Integer downloadQueueSize;

    private Encryption encryption;

    @JsonProperty("idle-seeding-limit")
    private Boolean idleSeedingLimit;

    @JsonProperty("incomplete-dir-enabled")
    private Boolean incompleteDirEnabled;

    @JsonProperty("incomplete-dir")
    private String incompleteDir;

    @JsonProperty("lpd-enabled")
    private Boolean lpdEnabled;

    @JsonProperty("peer-limit-global")
    private Integer peerLimitGlobal;

    @JsonProperty("peer-limit-per-torrent")
    private Integer peerLimitPerTorrent;

    @JsonProperty("peer-port-random-on-start")
    private Boolean peerPortRandomOnStart;

    @JsonProperty("peer-port")
    private Integer peerPort;

    @JsonProperty("pex-enabled")
    private Boolean pexEnabled;

    @JsonProperty("port-forwarding-enabled")
    private Boolean portForwardingEnabled;

    @JsonProperty("queue-stalled-enabled")
    private Boolean queueStalledEnabled;

    @JsonProperty("queue-stalled-minutes")
    private Integer queueStalledMinutes;

    @JsonProperty("rename-partial-files")
    private Boolean renamePartialFiles;

    @JsonProperty("script-torrent-added-enabled")
    private Boolean scriptTorrentAddedEnabled;

    @JsonProperty("script-torrent-added-filename")
    private String scriptTorrentAddedFilename;

    @JsonProperty("script-torrent-done-enabled")
    private Boolean scriptTorrentDoneEnabled;

    @JsonProperty("script-torrent-done-filename")
    private String scriptTorrentDoneFilename;

    @JsonProperty("script-torrent-done-seeding-enabled")
    private Boolean scriptTorrentDoneSeedingEnabled;

    @JsonProperty("script-torrent-done-seeding-filename")
    private String scriptTorrentDoneSeedingFilename;

    @JsonProperty("seed-queue-enabled")
    private Boolean seedQueueEnabled;

    @JsonProperty("seed-queue-size")
    private Integer seedQueueSize;

    private Float seedRatioLimit;

    private Boolean seedRatioLimited;

    @JsonProperty("speed-limit-down-enabled")
    private Boolean speedLimitDownEnabled;

    @JsonProperty("speed-limit-down")
    private Integer speedLimitDown;

    @JsonProperty("speed-limit-up-enabled")
    private Boolean speedLimitUpEnabled;

    @JsonProperty("speed-limit-up")
    private Integer speedLimitUp;

    @JsonProperty("start-added-torrents")
    private Boolean startAddedTorrents;

    @JsonProperty("trash-original-files")
    private Boolean trashOriginalFiles;

    @JsonProperty("utp-enabled")
    private Boolean utpEnabled;

}
