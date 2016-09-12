package cordelia.rpc.method;

import cordelia.rpc.Request;

/*

   "ids" specifies which torrents to use.
     * All torrents are used if the "ids" argument is omitted.
     * "ids" should be one of the following:
     * (1) an integer referring to a torrent id
     * (2) a list of torrent id numbers, sha1 hash strings, or both
     * (3) a string, "recently-active", for recently-active torrents

 */

public final class Torrent extends Request {

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

    public Torrent(Action action, Object... ids) {
        this(null, action, ids);
    }

    public Torrent(Integer tag, Action action, Object... ids) {
        super(action.method(), tag);
        this.arguments.put("ids", ids);
    }
}
