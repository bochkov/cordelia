package cordelia.rpc;

import org.cactoos.map.Solid;

import java.util.Map;

/*
   Request arguments:

   "cookies"            | string      pointer to a string of one or more cookies.
   "download-dir"       | string      path to download the torrent to
   "filename"           | string      filename or URL of the .torrent file
   "metainfo"           | string      base64-encoded .torrent content
   "paused"             | boolean     if true, don't start the torrent
   "peer-limit"         | number      maximum number of peers
   "bandwidthPriority"  | number      torrent's bandwidth tr_priority_t
   "files-wanted"       | array       indices of file(s) to download
   "files-unwanted"     | array       indices of file(s) to not download
   "priority-high"      | array       indices of high-priority file(s)
   "priority-low"       | array       indices of low-priority file(s)
   "priority-normal"    | array       indices of normal-priority file(s)

   Either "filename" OR "metainfo" MUST be included.
   All other arguments are optional.

   The format of the "cookies" should be NAME=CONTENTS, where NAME is the
   cookie name and CONTENTS is what the cookie should contain.
   Set multiple cookies like this: "name1=content1; name2=content2;" etc.
   <http://curl.haxx.se/libcurl/c/curl_easy_setopt.html#CURLOPTCOOKIE>

   Response arguments: On success, a "torrent-added" object in the
                       form of one of 3.3's tr_info objects with the
                       fields for id, name, and hashString.

                       On failure due to a duplicate torrent existing,
                       a "torrent-duplicate" object in the same form.
 */

public final class TorrentAdd extends AbsOptReq {

    public TorrentAdd(Map<String, Object> options) {
        this(11, options);
    }

    public TorrentAdd(Integer tag, Map<String, Object> options) {
        super(tag, "torrent-add", new Solid<>(options));
    }
}
