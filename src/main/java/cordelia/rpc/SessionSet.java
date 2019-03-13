package cordelia.rpc;

import org.cactoos.map.Solid;

import java.util.Map;

/*
   Request arguments: one or more of SessionGet's arguments, except: "blocklist-size",
                      "config-dir", "rpc-version", "rpc-version-minimum", and
                      "version"
 */

public final class SessionSet extends AbsOptReq {

    public SessionSet(Map<String, Object> options) {
        this(8, options);
    }

    public SessionSet(Integer tag, Map<String, Object> options) {
        super(tag, "session-set", new Solid<>(options));
    }
}
