package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import cordelia.jsonrpc.req.types.Encryption;
import cordelia.jsonrpc.req.types.SchedDay;
import cordelia.jsonrpc.req.types.Units;
import cordelia.jsonrpc.types.SKey;
import cordelia.util.NotNullToString;
import cordelia.util.SplitDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@Getter
@Setter
@ToString
public final class RsSessionGet extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    public static final class Result {

        /**
         * max global download speed (kB/s)
         */
        @JsonProperty(SKey.ALT_SPEED_DOWN)
        private Long altSpeedDown;

        /**
         * true means use the alt speeds
         */
        @JsonProperty(SKey.ALT_SPEED_ENABLED)
        private Boolean altSpeedEnabled;

        /**
         * when to turn on alt speeds (units: minutes after midnight)
         */
        @JsonProperty(SKey.ALT_SPEED_TIME_BEGIN)
        private Integer altSpeedTimeBegin;

        /**
         * what day(s) to turn on alt speeds (look at tr_sched_day)
         */
        @JsonProperty(SKey.ALT_SPEED_TIME_DAY)
        private SchedDay altSpeedTimeDay;

        /**
         * true means the scheduled on/off times are used
         */
        @JsonProperty(SKey.ALT_SPEED_TIME_ENABLED)
        private Boolean altSpeedTimeEnabled;

        /**
         * when to turn off alt speeds (units: same)
         */
        @JsonProperty(SKey.ALT_SPEED_TIME_END)
        private Integer altSpeedTimeEnd;

        /**
         * max global upload speed (kB/s)
         */
        @JsonProperty(SKey.ALT_SPEED_UP)
        private Long altSpeedUp;

        /**
         * true means to enable a basic brute force protection for RPC server
         */
        @JsonProperty(SKey.ANTI_BRUTE_FORCE_ENABLED)
        private Boolean antiBruteForceEnabled;

        /**
         * true means enabled
         */
        @JsonProperty(SKey.BLOCKLIST_ENABLED)
        private Boolean blocklistEnabled;

        /**
         * number of rules in the blocklist
         */
        @JsonProperty(SKey.BLOCKLIST_SIZE)
        private Integer blocklistSize;

        /**
         * location of the blocklist to use for blocklist_update
         */
        @JsonProperty(SKey.BLOCKLIST_URL)
        private String blocklistUrl;

        /**
         * maximum size of the disk cache (MiB).
         * Pieces are guaranteed to be written to filesystem if sequential download is enabled.
         * Otherwise, data might still be in cache only.
         */
        @JsonProperty(SKey.CACHE_SIZE_MIB)
        private Integer cacheSize;

        /**
         * location of transmission's configuration directory
         */
        @JsonProperty(SKey.CONFIG_DIR)
        private String configDir;

        /**
         * announce URLs, one per line, and a blank line between tiers.
         */
        @JsonProperty(SKey.DEFAULT_TRACKERS)
        @JsonDeserialize(using = SplitDeserializer.class)
        private List<String> defaultTrackers;

        /**
         * true means allow DHT in public torrents
         */
        @JsonProperty(SKey.DHT_ENABLED)
        private Boolean dhtEnabled;

        /**
         * default path to download torrents
         */
        @JsonProperty(SKey.DOWNLOAD_DIR)
        private String downloadDir;

        /**
         * if true, limit how many torrents can be downloaded at once
         */
        @JsonProperty(SKey.DOWNLOAD_QUEUE_ENABLED)
        private Boolean downloadQueueEnabled;

        /**
         * max number of torrents to download at once (see download_queue_enabled)
         */
        @JsonProperty(SKey.DOWNLOAD_QUEUE_SIZE)
        private Integer downloadQueueSize;

        /**
         * required, preferred, allowed
         */
        @JsonProperty(SKey.ENCRYPTION)
        private Encryption encryption;

        /**
         * torrents we're seeding will be stopped if they're idle for this long
         */
        @JsonProperty(SKey.IDLE_SEEDING_LIMIT)
        private Integer idleSeedingLimit;

        /**
         * true if the seeding inactivity limit is honored by default
         */
        @JsonProperty(SKey.IDLE_SEEDING_LIMIT_ENABLED)
        private Boolean idleSeedingLimitEnable;

        /**
         * path for incomplete torrents, when enabled
         */
        @JsonProperty(SKey.INCOMPLETE_DIR)
        private String incompleteDir;

        /**
         * true means keep torrents in incomplete_dir until done
         */
        @JsonProperty(SKey.INCOMPLETE_DIR_ENABLED)
        private Boolean incompleteDirEnabled;

        /**
         * true means allow Local Peer Discovery in public torrents
         */
        @JsonProperty(SKey.LPD_ENABLED)
        private Boolean lpdEnabled;

        /**
         * maximum global number of peers
         */
        @JsonProperty(SKey.PEER_LIMIT_GLOBAL)
        private Integer peerLimitGlobal;

        /**
         * maximum global number of peers
         */
        @JsonProperty(SKey.PEER_LIMIT_PER_TORRENT)
        private Integer peerLimitPerTorrent;

        /**
         * true means pick a random peer port on launch
         */
        @JsonProperty(SKey.PEER_PORT_RANDOM_ON_START)
        private Boolean peerPortRandomOnStart;

        /**
         * port number
         */
        @JsonProperty(SKey.PEER_PORT)
        private Integer peerPort;

        /**
         * true means allow PEX in public torrents
         */
        @JsonProperty(SKey.PEX_ENABLED)
        private Boolean pexEnabled;

        /**
         * true means ask upstream router to forward the configured peer port to transmission using UPnP or NAT-PMP
         */
        @JsonProperty(SKey.PORT_FORWARDING_ENABLED)
        private Boolean portForwardingEnabled;

        /**
         * preference of transport protocols, see settings.json for details
         */
        @JsonProperty(SKey.PREFERRED_TRANSPORTS)
        private List<String> preferredTransports;

        /**
         * whether or not to consider idle torrents as stalled
         */
        @JsonProperty(SKey.QUEUE_STALLED_ENABLED)
        private Boolean queueStalledEnabled;

        /**
         * torrents that are idle for N minuets aren't counted toward seed_queue_size or download_queue_size
         */
        @JsonProperty(SKey.QUEUE_STALLED_MINUTES)
        private Integer queueStalledMinutes;

        /**
         * true means append .part to incomplete files
         */
        @JsonProperty(SKey.RENAME_PARTIAL_FILES)
        private Boolean renamePartialFiles;

        /**
         * the number of outstanding block requests a peer is allowed to queue in the client
         */
        @JsonProperty(SKey.REQQ)
        private Integer reqq;

        /**
         * the current RPC API version in a semver-compatible string
         */
        @JsonProperty(SKey.RPC_VERSION_SEMVER)
        private String rpcVersionSemver;

        /**
         * whether or not to call the added script
         */
        @JsonProperty(SKey.SCRIPT_TORRENT_ADDED_ENABLED)
        private Boolean scriptTorrentAddedEnabled;

        /**
         * filename of the script to run
         */
        @JsonProperty(SKey.SCRIPT_TORRENT_ADDED_FILENAME)
        private String scriptTorrentAddedFilename;

        /**
         * whether or not to call the done script
         */
        @JsonProperty(SKey.SCRIPT_TORRENT_DONE_ENABLED)
        private Boolean scriptTorrentDoneEnabled;

        /**
         * filename of the script to run
         */
        @JsonProperty(SKey.SCRIPT_TORRENT_DONE_FILENAME)
        private String scriptTorrentDoneFilename;

        /**
         * whether or not to call the seeding_done script
         */
        @JsonProperty(SKey.SCRIPT_TORRENT_DONE_SEEDING_ENABLED)
        private Boolean scriptTorrentDoneSeedingEnabled;

        /**
         * filename of the script to run
         */
        @JsonProperty(SKey.SCRIPT_TORRENT_DONE_SEEDING_FILENAME)
        private String scriptTorrentDoneSeedingFilename;

        /**
         * if true, limit how many torrents can be uploaded at once
         */
        @JsonProperty(SKey.SEED_QUEUE_ENABLED)
        private Boolean seedQueueEnabled;

        /**
         * max number of torrents to uploaded at once (see seed_queue_enabled)
         */
        @JsonProperty(SKey.SEED_QUEUE_SIZE)
        private Integer seedQueueSize;

        /**
         * the default seed ratio for torrents to use
         */
        @JsonProperty(SKey.SEED_RATIO_LIMIT)
        private Double seedRatioLimit;

        /**
         * true if seed_ratio_limit is honored by default
         */
        @JsonProperty(SKey.SEED_RATIO_LIMITED)
        private Boolean seedRatioLimited;

        /**
         * true means sequential download is enabled by default for added torrents
         */
        @JsonProperty(SKey.SEQUENTIAL_DOWNLOAD)
        private Boolean sequentialDownload;

        /**
         * the current X-Transmission-Session-Id value
         */
        @JsonProperty(SKey.SESSION_ID)
        private String sessionId;

        /**
         * max global download speed (kB/s)
         */
        @JsonProperty(SKey.SPEED_LIMIT_DOWN)
        private Integer speedLimitDown;

        /**
         * true means enabled
         */
        @JsonProperty(SKey.SPEED_LIMIT_DOWN_ENABLED)
        private Boolean speedLimitDownEnabled;

        /**
         * max global upload speed (kB/s)
         */
        @JsonProperty(SKey.SPEED_LIMIT_UP)
        private Integer speedLimitUp;

        /**
         * true means enabled
         */
        @JsonProperty(SKey.SPEED_LIMIT_UP_ENABLED)
        private Boolean speedLimitUpEnabled;

        /**
         * true means added torrents will be started right away
         */
        @JsonProperty(SKey.START_ADDED_TORRENTS)
        private Boolean startAddedTorrents;

        /**
         * true means the .torrent file of added torrents will be deleted
         */
        @JsonProperty(SKey.TRASH_ORIGINAL_TORRENT_FILES)
        private Boolean trashOriginalFiles;

        @JsonProperty(SKey.UNITS)
        private Units units;

        /**
         * long version string $version ($revision)
         */
        @JsonProperty(SKey.VERSION)
        private String version;

        @Override
        public String toString() {
            return NotNullToString.eval(this);
        }
    }
}
