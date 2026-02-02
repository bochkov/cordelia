package cordelia.jsonrpc.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SKey {

    /**
     * max global download speed (kB/s)
     */
    public static final String ALT_SPEED_DOWN = "alt_speed_down";

    /**
     * true means use the alt speeds
     */
    public static final String ALT_SPEED_ENABLED = "alt_speed_enabled";

    /**
     * when to turn on alt speeds (units: minutes after midnight)
     */
    public static final String ALT_SPEED_TIME_BEGIN = "alt_speed_time_begin";

    /**
     * what day(s) to turn on alt speeds (look at tr_sched_day)
     */
    public static final String ALT_SPEED_TIME_DAY = "alt_speed_time_day";

    /**
     * true means the scheduled on/off times are used
     */
    public static final String ALT_SPEED_TIME_ENABLED = "alt_speed_time_enabled";

    /**
     * when to turn off alt speeds (units: same)
     */
    public static final String ALT_SPEED_TIME_END = "alt_speed_time_end";

    /**
     * max global upload speed (kB/s)
     */
    public static final String ALT_SPEED_UP = "alt_speed_up";

    /**
     * true means to enable a basic brute force protection for RPC server
     */
    public static final String ANTI_BRUTE_FORCE_ENABLED = "anti_brute_force_enabled";

    /**
     * true means enabled
     */
    public static final String BLOCKLIST_ENABLED = "blocklist_enabled";

    /**
     * number of rules in the blocklist
     */
    public static final String BLOCKLIST_SIZE = "blocklist_size";

    /**
     * location of the blocklist to use for blocklist_update
     */
    public static final String BLOCKLIST_URL = "blocklist_url";

    /**
     * maximum size of the disk cache (MiB).
     * Pieces are guaranteed to be written to filesystem if sequential download is enabled.
     * Otherwise, data might still be in cache only.
     */
    public static final String CACHE_SIZE_MIB = "cache_size_mib";

    /**
     * location of transmission's configuration directory
     */
    public static final String CONFIG_DIR = "config_dir";

    /**
     * announce URLs, one per line, and a blank line between tiers.
     */
    public static final String DEFAULT_TRACKERS = "default_trackers";

    /**
     * true means allow DHT in public torrents
     */
    public static final String DHT_ENABLED = "dht_enabled";

    /**
     * default path to download torrents
     */
    public static final String DOWNLOAD_DIR = "download_dir";

    /**
     * if true, limit how many torrents can be downloaded at once
     */
    public static final String DOWNLOAD_QUEUE_ENABLED = "download_queue_enabled";

    /**
     * max number of torrents to download at once (see download_queue_enabled)
     */
    public static final String DOWNLOAD_QUEUE_SIZE = "download_queue_size";

    /**
     * required, preferred, allowed
     */
    public static final String ENCRYPTION = "encryption";

    /**
     * torrents we're seeding will be stopped if they're idle for this long
     */
    public static final String IDLE_SEEDING_LIMIT = "idle_seeding_limit";

    /**
     * true if the seeding inactivity limit is honored by default
     */
    public static final String IDLE_SEEDING_LIMIT_ENABLED = "idle_seeding_limit_enabled";

    /**
     * path for incomplete torrents, when enabled
     */
    public static final String INCOMPLETE_DIR = "incomplete_dir";

    /**
     * true means keep torrents in incomplete_dir until done
     */
    public static final String INCOMPLETE_DIR_ENABLED = "incomplete_dir_enabled";

    /**
     * true means allow Local Peer Discovery in public torrents
     */
    public static final String LPD_ENABLED = "lpd_enabled";

    /**
     * maximum global number of peers
     */
    public static final String PEER_LIMIT_GLOBAL = "peer_limit_global";

    /**
     * maximum global number of peers
     */
    public static final String PEER_LIMIT_PER_TORRENT = "peer_limit_per_torrent";

    /**
     * true means pick a random peer port on launch
     */
    public static final String PEER_PORT_RANDOM_ON_START = "peer_port_random_on_start";

    /**
     * port number
     */
    public static final String PEER_PORT = "peer_port";

    /**
     * true means allow PEX in public torrents
     */
    public static final String PEX_ENABLED = "pex_enabled";

    /**
     * true means ask upstream router to forward the configured peer port to transmission using UPnP or NAT-PMP
     */
    public static final String PORT_FORWARDING_ENABLED = "port_forwarding_enabled";

    /**
     * preference of transport protocols, see settings.json for details
     */
    public static final String PREFERRED_TRANSPORTS = "preferred_transports";

    /**
     * whether or not to consider idle torrents as stalled
     */
    public static final String QUEUE_STALLED_ENABLED = "queue_stalled_enabled";

    /**
     * torrents that are idle for N minutes aren't counted toward seed_queue_size or download_queue_size
     */
    public static final String QUEUE_STALLED_MINUTES = "queue_stalled_minutes";

    /**
     * true means append .part to incomplete files
     */
    public static final String RENAME_PARTIAL_FILES = "rename_partial_files";

    /**
     * the number of outstanding block requests a peer is allowed to queue in the client
     */
    public static final String REQQ = "reqq";

    /**
     * the current RPC API version in a semver-compatible string
     */
    public static final String RPC_VERSION_SEMVER = "rpc_version_semver";

    /**
     * whether or not to call the added script
     */
    public static final String SCRIPT_TORRENT_ADDED_ENABLED = "script_torrent_added_enabled";

    /**
     * filename of the script to run
     */
    public static final String SCRIPT_TORRENT_ADDED_FILENAME = "script_torrent_added_filename";

    /**
     * whether or not to call the done script
     */
    public static final String SCRIPT_TORRENT_DONE_ENABLED = "script_torrent_done_enabled";

    /**
     * filename of the script to run
     */
    public static final String SCRIPT_TORRENT_DONE_FILENAME = "script_torrent_done_filename";

    /**
     * whether or not to call the seeding_done script
     */
    public static final String SCRIPT_TORRENT_DONE_SEEDING_ENABLED = "script_torrent_done_seeding_enabled";

    /**
     * filename of the script to run
     */
    public static final String SCRIPT_TORRENT_DONE_SEEDING_FILENAME = "script_torrent_done_seeding_filename";

    /**
     * if true, limit how many torrents can be uploaded at once
     */
    public static final String SEED_QUEUE_ENABLED = "seed_queue_enabled";

    /**
     * max number of torrents to uploaded at once (see seed_queue_enabled)
     */
    public static final String SEED_QUEUE_SIZE = "seed_queue_size";

    /**
     * the default seed ratio for torrents to use
     */
    public static final String SEED_RATIO_LIMIT = "seed_ratio_limit";

    /**
     * true if seed_ratio_limit is honored by default
     */
    public static final String SEED_RATIO_LIMITED = "seed_ratio_limited";

    /**
     * true means sequential download is enabled by default for added torrents
     */
    public static final String SEQUENTIAL_DOWNLOAD = "sequential_download";

    /**
     * the current X-Transmission-Session-Id value
     */
    public static final String SESSION_ID = "session_id";

    /**
     * max global download speed (kB/s)
     */
    public static final String SPEED_LIMIT_DOWN = "speed_limit_down";

    /**
     * true means enabled
     */
    public static final String SPEED_LIMIT_DOWN_ENABLED = "speed_limit_down_enabled";

    /**
     * max global upload speed (kB/s)
     */
    public static final String SPEED_LIMIT_UP = "speed_limit_up";

    /**
     * true means enabled
     */
    public static final String SPEED_LIMIT_UP_ENABLED = "speed_limit_up_enabled";

    /**
     * true means added torrents will be started right away
     */
    public static final String START_ADDED_TORRENTS = "start_added_torrents";

    /**
     * true means the .torrent file of added torrents will be deleted
     */
    public static final String TRASH_ORIGINAL_TORRENT_FILES = "trash_original_torrent_files";

    /**
     * see below
     */
    public static final String UNITS = "units";

    /**
     * long version string $version ($revision)
     */
    public static final String VERSION = "version";

}
