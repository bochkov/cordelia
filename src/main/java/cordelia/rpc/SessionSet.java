package cordelia.rpc;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/*
   Request arguments: one or more of SessionGet's arguments, except: "blocklist-size",
                      "config-dir", "rpc-version", "rpc-version-minimum", and
                      "version"
 */

public final class SessionSet implements Serializable {

    private final String method = "session-set";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public SessionSet(Map<String, Object> options) {
        this(null, options);
    }

    public SessionSet(Integer tag, Map<String, Object> options) {
        this.tag = tag;
        this.arguments = Collections.unmodifiableMap(options);
    }
}
