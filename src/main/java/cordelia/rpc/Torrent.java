package cordelia.rpc;

import java.util.List;
import java.util.Map;

/*
   "ids" specifies which torrents to use.
     * All torrents are used if the "ids" argument is omitted.
     * "ids" should be one of the following:
     * (1) an integer referring to a torrent id
     * (2) a list of torrent id numbers, sha1 hash strings, or both
     * (3) a string, "recently-active", for recently-active torrents
 */

public final class Torrent extends AbsOptReq {

    public Torrent(Action action, Object... ids) {
        this(10, action, ids);
    }

    public Torrent(Integer tag, Action action, Object... ids) {
        super(
                tag,
                action.method(),
                ids.length > 0 ?
                        Map.of("ids", List.of(ids)) :
                        Map.of()
        );
    }

    public enum Action {
        START("torrent-start"),
        START_NOW("torrent-start-now"),
        STOP("torrent-stop"),
        VERIFY("torrent-verify"),
        REANNOUNCE("torrent-reannounce");

        private final String method;

        Action(String method) {
            this.method = method;
        }

        public String method() {
            return method;
        }
    }
}
