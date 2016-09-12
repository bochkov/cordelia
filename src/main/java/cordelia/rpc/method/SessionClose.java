package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class SessionClose extends Request {

    public static final String METHOD = "session-close";

    public SessionClose() {
        this(null);
    }

    public SessionClose(Integer tag) {
        super(METHOD, tag);
    }
}
