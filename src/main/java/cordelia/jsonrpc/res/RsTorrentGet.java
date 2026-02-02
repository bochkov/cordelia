package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import cordelia.jsonrpc.RpcResponse;
import cordelia.jsonrpc.req.types.IdleLimit;
import cordelia.jsonrpc.req.types.Priority;
import cordelia.jsonrpc.req.types.RatioLimit;
import cordelia.jsonrpc.types.FKey;
import cordelia.util.Base64Deserialize;
import cordelia.util.NotNullToString;
import cordelia.util.SplitDeserializer;
import cordelia.util.UnixTimestampDeserialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public final class RsTorrentGet extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {
        @JsonProperty
        private List<Torrents> torrents;
        @JsonProperty
        private List<Integer> removed;
    }

    @Getter
    @Setter
    public static final class Torrents {

        @JsonProperty(FKey.ACTIVITY_DATE)
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime activityDate;

        @JsonProperty(FKey.ADDED_DATE)
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime addedDate;

        @JsonProperty(FKey.AVAILABILITY)
        private List<Integer> availability;

        @JsonProperty(FKey.BANDWIDTH_PRIORITY)
        private Priority bandwidthPriority;

        @JsonProperty(FKey.BYTES_COMPLETED)
        private List<Long> bytesCompleted;

        @JsonProperty(FKey.COMMENT)
        private String comment;

        @JsonProperty(FKey.CORRUPT_EVER)
        private Long corruptEver;

        @JsonProperty(FKey.CREATOR)
        private String creator;

        @JsonProperty(FKey.DATE_CREATED)
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime dateCreated;

        @JsonProperty(FKey.DESIRED_AVAILABLE)
        private Integer desiredAvailable;

        @JsonProperty(FKey.DONE_DATE)
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime doneDate;

        @JsonProperty(FKey.DOWNLOAD_DIR)
        private String downloadDir;

        @JsonProperty(FKey.DOWNLOADED_EVER)
        private Long downloadedEver;

        @JsonProperty(FKey.DOWNLOAD_LIMIT)
        private Integer downloadLimit;

        @JsonProperty(FKey.DOWNLOAD_LIMITED)
        private Boolean downloadLimited;

        @JsonProperty(FKey.EDIT_DATE)
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime editDate;

        @JsonProperty(FKey.ERROR)
        private Long error;

        @JsonProperty(FKey.ERROR_STRING)
        private String errorString;

        @JsonProperty(FKey.ETA)
        private Long eta;

        @JsonProperty(FKey.ETA_IDLE)
        private Long etaIdle;

        @JsonProperty(FKey.FILE_COUNT)
        private Long fileCount;

        @JsonProperty(FKey.FILES)
        private List<Files> files;

        @JsonProperty(FKey.FILE_STATS)
        private List<FileStats> fileStats;

        @JsonProperty(FKey.GROUP)
        private String group;

        @JsonProperty(FKey.HASH_STRING)
        private String hashString;

        @JsonProperty(FKey.HAVE_UNCHECKED)
        private Integer haveUnchecked;

        @JsonProperty(FKey.HAVE_VALID)
        private Long haveValid;

        @JsonProperty(FKey.HONORS_SESSION_LIMITS)
        private Boolean honorsSessionLimits;

        @JsonProperty(FKey.ID)
        private Long id;

        @JsonProperty(FKey.IS_FINISHED)
        private Boolean isFinished;

        @JsonProperty(FKey.IS_PRIVATE)
        private Boolean isPrivate;

        @JsonProperty(FKey.IS_STALLED)
        private Boolean isStalled;

        @JsonProperty(FKey.LABELS)
        private List<String> labels;

        @JsonProperty(FKey.LEFT_UNTIL_DONE)
        private Long leftUntilDone;

        @JsonProperty(FKey.MAGNET_LINK)
        private String magnetLink;

        @JsonProperty(FKey.MAX_CONNECTED_PEERS)
        private Integer maxConnectedPeers;

        @JsonProperty(FKey.METADATA_PERCENT_COMPLETE)
        private Double metadataPercentComplete;

        @JsonProperty(FKey.NAME)
        private String name;

        @JsonProperty(FKey.PEER_LIMIT)
        private Integer peerLimit;

        @JsonProperty(FKey.PEERS)
        private List<Peers> peers;

        @JsonProperty(FKey.PEERS_CONNECTED)
        private Integer peersConnected;

        @JsonProperty(FKey.PEERS_FROM)
        private PeersFrom peersFrom;

        @JsonProperty(FKey.PEERS_GETTING_FROM_US)
        private Integer peersGettingFromUs;

        @JsonProperty(FKey.PEERS_SENDING_TO_US)
        private Integer peersSendingToUs;

        @JsonProperty(FKey.PERCENT_COMPLETE)
        private Double percentComplete;

        @JsonProperty(FKey.PERCENT_DONE)
        private Double percentDone;

        @JsonProperty(FKey.PIECES)
        @JsonDeserialize(using = Base64Deserialize.class)
        private byte[] pieces;

        @JsonProperty(FKey.PIECE_COUNT)
        private Long pieceCount;

        @JsonProperty(FKey.PIECE_SIZE)
        private Long pieceSize;

        @JsonProperty(FKey.PRIORITIES)
        private List<Priority> priorities;

        @JsonProperty(FKey.PRIMARY_MIME_TYPE)
        private String primaryMimeType;

        @JsonProperty(FKey.QUEUE_POSITION)
        private Integer queuePosition;

        @JsonProperty(FKey.RATE_DOWNLOAD)
        private Long rateDownload;

        @JsonProperty(FKey.RATE_UPLOAD)
        private Long rateUpload;

        @JsonProperty(FKey.RECHECK_PROGRESS)
        private Double recheckProgress;

        @JsonProperty(FKey.SECONDS_DOWNLOADING)
        private Long secondsDownloading;

        @JsonProperty(FKey.SECONDS_SEEDING)
        private Long secondsSeeding;

        @JsonProperty(FKey.SEED_IDLE_LIMIT)
        private Long seedIdleLimit;

        @JsonProperty(FKey.SEED_IDLE_MODE)
        private IdleLimit seedIdleMode;

        @JsonProperty(FKey.SEED_RATIO_LIMIT)
        private Double seedRatioLimit;

        @JsonProperty(FKey.SEED_RATIO_MODE)
        private RatioLimit seedRatioMode;

        @JsonProperty(FKey.SEQUENTIAL_DOWNLOAD)
        private Boolean sequentialDownload;

        @JsonProperty(FKey.SEQUENTIAL_DOWNLOAD_FROM_PIECE)
        private Long sequentialDownloadFromPiece;

        @JsonProperty(FKey.SIZE_WHEN_DONE)
        private Long sizeWhenDone;

        @JsonProperty(FKey.START_DATE)
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime startDate;

        @JsonProperty(FKey.STATUS)
        private Status status;

        @JsonProperty(FKey.TORRENT_FILE)
        private String torrentFile;

        @JsonProperty(FKey.TOTAL_SIZE)
        private Long totalSize;

        @JsonProperty(FKey.TRACKERS)
        private List<Tracker> trackers;

        @JsonProperty(FKey.TRACKER_LIST)
        @JsonDeserialize(using = SplitDeserializer.class)
        private List<String> trackerList;

        @JsonProperty(FKey.TRACKER_STATS)
        private List<TrackerStat> trackerStats;

        @JsonProperty(FKey.UPLOADED_EVER)
        private Long uploadedEver;

        @JsonProperty(FKey.UPLOAD_LIMIT)
        private Integer uploadLimit;

        @JsonProperty(FKey.UPLOAD_LIMITED)
        private Boolean uploadLimited;

        @JsonProperty(FKey.UPLOAD_RATIO)
        private Double uploadRatio;

        @JsonProperty(FKey.WANTED)
        private List<Boolean> wanted;

        @JsonProperty(FKey.WEB_SEEDS)
        private List<String> webSeeds;

        @JsonProperty(FKey.WEB_SEEDS_SENDING_TO_US)
        private Long webSeedsSendingToUs;

        @Override
        public String toString() {
            return NotNullToString.eval(this);
        }
    }

    @Getter
    @Setter
    @ToString
    private static final class Files {

        @JsonProperty("bytes_completed")
        private Long bytesCompleted;

        @JsonProperty
        private Long length;

        @JsonProperty
        private String name;

        @JsonProperty("begin_piece")
        private Integer beginPiece;

        @JsonProperty("end_piece")
        private Integer endPiece;

    }

    @Getter
    @Setter
    @ToString
    public static final class FileStats {

        @JsonProperty("bytes_completed")
        private Long bytesCompleted;

        @JsonProperty
        private Boolean wanted;

        @JsonProperty
        private Integer priority;

    }

    @Getter
    @Setter
    @ToString
    public static final class Peers {

        @JsonProperty
        private String address;

        @JsonProperty("bytes_to_client")
        private Long bytesToClient;

        @JsonProperty("bytes_to_peer")
        private Long bytesToPeer;

        @JsonProperty("client_is_chocked")
        private Boolean clientIsChocked;

        @JsonProperty("client_is_interested")
        private Boolean clientIsInterested;

        @JsonProperty("client_name")
        private String clientName;

        @JsonProperty("flag_str")
        private String flagStr;

        @JsonProperty("is_downloading_from")
        private Boolean isDownloadingFrom;

        @JsonProperty("is_encrypted")
        private Boolean isEncrypted;

        @JsonProperty("is_incoming")
        private Boolean isIncoming;

        @JsonProperty("is_uploading_to")
        private Boolean isUploadingTo;

        @JsonProperty("is_utp")
        private Boolean isUTP;

        @JsonProperty("peer_is_chocked")
        private Boolean peerIsChocked;

        @JsonProperty("peer_is_interested")
        private Boolean peerIsInterested;

        @JsonProperty
        private Integer port;

        @JsonProperty
        private Double progress;

        @JsonProperty("rate_to_client")
        private Long rateToClient;

        @JsonProperty("rate_to_peer")
        private Long rateToPeer;

    }

    @Getter
    @Setter
    @ToString
    public static final class PeersFrom {
        @JsonProperty("from_cache")
        private Integer fromCache;

        @JsonProperty("from_dht")
        private Integer fromDht;

        @JsonProperty("from_incoming")
        private Integer fromIncoming;

        @JsonProperty("from_lpd")
        private Integer fromLpd;

        @JsonProperty("from_ltep")
        private Integer fromLtep;

        @JsonProperty("from_pex")
        private Integer fromPex;

        @JsonProperty("from_tracker")
        private Integer fromTracker;

    }

    @RequiredArgsConstructor
    public enum Status {

        /**
         * Torrent is stopped
         */
        STOPPED(0),
        /**
         * Torrent is queued to verify local data
         */
        QUEUED_TO_VERIFY(1),
        /**
         * Torrent is verifying local data
         */
        VERIFYING(2),
        /**
         * Torrent is queued to download
         */
        QUEUED_TO_DOWNLOAD(3),
        /**
         * Torrent is downloading
         */
        DOWNLOADING(4),
        /**
         * Torrent is queued to seed
         */
        QUEUED_TO_SEED(5),
        /**
         * Torrent is seeding
         */
        SEEDING(6);

        @JsonValue
        private final int idx;

    }

    @Getter
    @Setter
    @ToString
    public static final class Tracker {

        @JsonProperty
        private String announce;
        @JsonProperty
        private Integer id;
        @JsonProperty
        private String scrape;
        @JsonProperty("sitename")
        private String siteName;
        @JsonProperty
        private Integer tier;

    }

    @Getter
    @Setter
    @ToString
    public static final class TrackerStat {

        @JsonProperty
        private String announce;

        @JsonProperty("announce_state")
        private Integer announceState;

        @JsonProperty("download_count")
        private Integer downloadCount;

        @JsonProperty("downloader_count")
        private Integer downloaderCount;

        @JsonProperty("has_announced")
        private Boolean hasAnnounced;

        @JsonProperty("has_scraped")
        private Boolean hasScraped;

        @JsonProperty
        private String host;

        @JsonProperty
        private Integer id;

        @JsonProperty("is_backup")
        private Boolean isBackup;

        @JsonProperty("last_announce_peer_count")
        private Integer lastAnnouncePeerCount;

        @JsonProperty("last_announce_result")
        private String lastAnnounceResult;

        @JsonProperty("last_announce_start_time")
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime lastAnnounceStartTime;

        @JsonProperty("last_announce_succeeded")
        private Boolean lastAnnounceSucceeded;

        @JsonProperty("last_announce_time")
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime lastAnnounceTime;

        @JsonProperty("last_announce_timed_out")
        private Boolean lastAnnounceTimedOut;

        @JsonProperty("last_scraped_result")
        private String lastScrapeResult;

        @JsonProperty("last_scraped_start_time")
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime lastScrapeStartTime;

        @JsonProperty("last_scrape_succeeded")
        private Boolean lastScrapeSucceeded;

        @JsonProperty("last_scrape_time")
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime lastScrapeTime;

        @JsonProperty("last_scrape_timed_out")
        private Boolean lastScrapeTimedOut;

        @JsonProperty("leecher_count")
        private Integer leecherCount;

        @JsonProperty("next_announce_time")
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime nextAnnounceTime;

        @JsonProperty("next_scrape_time")
        @JsonDeserialize(using = UnixTimestampDeserialize.class)
        private LocalDateTime nextScrapeTime;

        @JsonProperty
        private String scrape;

        @JsonProperty("scrape_state")
        private Integer scrapeState;

        @JsonProperty("seeder_count")
        private Integer seederCount;

        @JsonProperty("sitename")
        private String siteName;

        @JsonProperty
        private Integer tier;

    }


}
