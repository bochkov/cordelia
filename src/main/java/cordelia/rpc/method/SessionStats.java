package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class SessionStats extends Request {

    public static final String METHOD = "session-stats";

    public SessionStats() {
        this(null);
    }

    public SessionStats(Integer tag) {
        super(METHOD, tag);
    }
}
