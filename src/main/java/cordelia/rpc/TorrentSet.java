package cordelia.rpc;

import org.cactoos.map.SolidMap;

import java.util.Map;

/*
Request arguments:

   "bandwidthPriority"   | number     this torrent's bandwidth tr_priority_t
   "downloadLimit"       | number     maximum download speed (KBps)
   "downloadLimited"     | boolean    true if "downloadLimit" is honored
   "files-wanted"        | array      indices of file(s) to download
   "files-unwanted"      | array      indices of file(s) to not download
   "honorsSessionLimits" | boolean    true if session upload limits are honored
   "ids"                 | array      torrent list, as described in 3.1
   "location"            | string     new location of the torrent's content
   "peer-limit"          | number     maximum number of peers
   "priority-high"       | array      indices of high-priority file(s)
   "priority-low"        | array      indices of low-priority file(s)
   "priority-normal"     | array      indices of normal-priority file(s)
   "queuePosition"       | number     position of this torrent in its queue [0...n)
   "seedIdleLimit"       | number     torrent-level number of minutes of seeding inactivity
   "seedIdleMode"        | number     which seeding inactivity to use.  See tr_idlelimit
   "seedRatioLimit"      | double     torrent-level seeding ratio
   "seedRatioMode"       | number     which ratio to use.  See tr_ratiolimit
   "trackerAdd"          | array      strings of announce URLs to add
   "trackerRemove"       | array      ids of trackers to remove
   "trackerReplace"      | array      pairs of <trackerId/new announce URLs>
   "uploadLimit"         | number     maximum upload speed (KBps)
   "uploadLimited"       | boolean    true if "uploadLimit" is honored

   Just as an empty "ids" value is shorthand for "all ids", using an empty array
   for "files-wanted", "files-unwanted", "priority-high", "priority-low", or
   "priority-normal" is shorthand for saying "all files".
 */

public final class TorrentSet implements OptReq {

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentSet(Map<String, Object> options) {
        this(15, options);
    }

    public TorrentSet(Integer tag, Map<String, Object> options) {
        this.tag = tag;
        this.method = "torrent-set";
        this.arguments = new SolidMap<>(options);
    }

    @Override
    public Map<String, Object> arguments() {
        return arguments;
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public Integer tag() {
        return tag;
    }
}
