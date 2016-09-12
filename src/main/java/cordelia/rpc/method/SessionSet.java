package cordelia.rpc.method;

import cordelia.rpc.Request;

import java.util.Map;

/*

   Request arguments: one or more of SessionGet's arguments, except: "blocklist-size",
                      "config-dir", "rpc-version", "rpc-version-minimum", and
                      "version"

 */

public final class SessionSet extends Request {

    public static final String METHOD = "session-set";

    public SessionSet(Map<String, Object> options) {
        this(null, options);
    }

    public SessionSet(Integer tag, Map<String, Object> options) {
        super(METHOD, tag);
        this.arguments.putAll(options);
    }
}
