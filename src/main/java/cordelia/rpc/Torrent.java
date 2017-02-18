package cordelia.rpc;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
   "ids" specifies which torrents to use.
     * All torrents are used if the "ids" argument is omitted.
     * "ids" should be one of the following:
     * (1) an integer referring to a torrent id
     * (2) a list of torrent id numbers, sha1 hash strings, or both
     * (3) a string, "recently-active", for recently-active torrents
 */

public final class Torrent implements Serializable {

    public enum Action {
        START("torrent-start"),
        START_NOW("torrent-start-now"),
        STOP("torrent-stop"),
        VERIFY("torrent-verify"),
        REANNOUNCE("torrent-reannounce");

        private String method;

        Action(String method) {
            this.method = method;
        }

        public String method() {
            return method;
        }
    }

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public Torrent(Action action, Object... ids) {
        this(null, action, ids);
    }

    public Torrent(Integer tag, Action action, Object... ids) {
        this.method = action.method();
        this.tag = tag;
        Map<String, Object> map = new HashMap<>();
        map.put("ids", Arrays.asList(ids));
        this.arguments = Collections.unmodifiableMap(map);
    }
}
