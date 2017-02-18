package cordelia.rpc;

import java.io.Serializable;

public final class SessionClose implements Serializable {

    private final String method = "session-close";
    private final Integer tag;

    public SessionClose() {
        this(null);
    }

    public SessionClose(Integer tag) {
        this.tag = tag;
    }
}
