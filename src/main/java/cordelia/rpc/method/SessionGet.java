package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class SessionGet extends Request {

    public static final String METHOD = "session-get";

    public SessionGet() {
        this(null);
    }

    public SessionGet(Integer tag) {
        super(METHOD, tag);
    }
}
