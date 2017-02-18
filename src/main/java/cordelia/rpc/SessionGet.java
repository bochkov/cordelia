package cordelia.rpc;

import java.io.Serializable;

/*
   "alt-speed-down"                 | number     | max global download speed (KBps)
   "alt-speed-enabled"              | boolean    | true means use the alt speeds
   "alt-speed-time-begin"           | number     | when to turn on alt speeds (units: minutes after midnight)
   "alt-speed-time-enabled"         | boolean    | true means the scheduled on/off times are used
   "alt-speed-time-end"             | number     | when to turn off alt speeds (units: same)
   "alt-speed-time-day"             | number     | what day(s) to turn on alt speeds (look at tr_sched_day)
   "alt-speed-up"                   | number     | max global upload speed (KBps)
   "blocklist-url"                  | string     | location of the blocklist to use for "blocklist-update"
   "blocklist-enabled"              | boolean    | true means enabled
   "blocklist-size"                 | number     | number of rules in the blocklist
   "cache-size-mb"                  | number     | maximum size of the disk cache (MB)
   "config-dir"                     | string     | location of transmission's configuration directory
   "download-dir"                   | string     | default path to download torrents
   "download-queue-size"            | number     | max number of torrents to download at once (see download-queue-enabled)
   "download-queue-enabled"         | boolean    | if true, limit how many torrents can be downloaded at once
   "dht-enabled"                    | boolean    | true means allow dht in public torrents
   "encryption"                     | string     | "required", "preferred", "tolerated"
   "idle-seeding-limit"             | number     | torrents we're seeding will be stopped if they're idle for this long
   "idle-seeding-limit-enabled"     | boolean    | true if the seeding inactivity limit is honored by default
   "incomplete-dir"                 | string     | path for incomplete torrents, when enabled
   "incomplete-dir-enabled"         | boolean    | true means keep torrents in incomplete-dir until done
   "lpd-enabled"                    | boolean    | true means allow Local Peer Discovery in public torrents
   "peer-limit-global"              | number     | maximum global number of peers
   "peer-limit-per-torrent"         | number     | maximum global number of peers
   "pex-enabled"                    | boolean    | true means allow pex in public torrents
   "peer-port"                      | number     | port number
   "peer-port-random-on-start"      | boolean    | true means pick a random peer port on launch
   "port-forwarding-enabled"        | boolean    | true means enabled
   "queue-stalled-enabled"          | boolean    | whether or not to consider idle torrents as stalled
   "queue-stalled-minutes"          | number     | torrents that are idle for N minuets aren't counted toward seed-queue-size or download-queue-size
   "rename-partial-files"           | boolean    | true means append ".part" to incomplete files
   "rpc-version"                    | number     | the current RPC API version
   "rpc-version-minimum"            | number     | the minimum RPC API version supported
   "script-torrent-done-filename"   | string     | filename of the script to run
   "script-torrent-done-enabled"    | boolean    | whether or not to call the "done" script
   "seedRatioLimit"                 | double     | the default seed ratio for torrents to use
   "seedRatioLimited"               | boolean    | true if seedRatioLimit is honored by default
   "seed-queue-size"                | number     | max number of torrents to uploaded at once (see seed-queue-enabled)
   "seed-queue-enabled"             | boolean    | if true, limit how many torrents can be uploaded at once
   "speed-limit-down"               | number     | max global download speed (KBps)
   "speed-limit-down-enabled"       | boolean    | true means enabled
   "speed-limit-up"                 | number     | max global upload speed (KBps)
   "speed-limit-up-enabled"         | boolean    | true means enabled
   "start-added-torrents"           | boolean    | true means added torrents will be started right away
   "trash-original-torrent-files"   | boolean    | true means the .torrent file of added torrents will be deleted
   "units"                          | object     | see below
   "utp-enabled"                    | boolean    | true means allow utp
   "version"                        | string     | long version string "$version ($revision)"
   ---------------------------------+------------+-----------------------------+
   units                            | object containing:                       |
                                    +--------------+--------+------------------+
                                    | speed-units  | array  | 4 strings: KB/s, MB/s, GB/s, TB/s
                                    | speed-bytes  | number | number of bytes in a KB (1000 for kB; 1024 for KiB)
                                    | size-units   | array  | 4 strings: KB/s, MB/s, GB/s, TB/s
                                    | size-bytes   | number | number of bytes in a KB (1000 for kB; 1024 for KiB)
                                    | memory-units | array  | 4 strings: KB/s, MB/s, GB/s, TB/s
                                    | memory-bytes | number | number of bytes in a KB (1000 for kB; 1024 for KiB)
                                    +--------------+--------+------------------+
 */

public final class SessionGet implements Serializable {

    private final String method = "session-get";
    private final Integer tag;

    public SessionGet() {
        this(null);
    }

    public SessionGet(Integer tag) {
        this.tag = tag;
    }
}
