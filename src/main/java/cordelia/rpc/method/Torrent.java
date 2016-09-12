package cordelia.rpc.method;

import cordelia.rpc.Request;

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
