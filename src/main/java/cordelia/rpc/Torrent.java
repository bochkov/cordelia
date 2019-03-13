package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

import java.util.Collections;

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
                        Collections.unmodifiableMap(
                                new MapOf<String, Object>(
                                        new MapEntry<>("ids", new ListOf<>(ids))
                                )
                        ) :
                        Collections.unmodifiableMap(
                                new MapOf<>()
                        )
        );
    }

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
}
