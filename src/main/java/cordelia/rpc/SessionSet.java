package cordelia.rpc;

import org.cactoos.map.SolidMap;

import java.util.Map;

/*
   Request arguments: one or more of SessionGet's arguments, except: "blocklist-size",
                      "config-dir", "rpc-version", "rpc-version-minimum", and
                      "version"
 */

public final class SessionSet implements OptReq {

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public SessionSet(Integer tag, Map<String, Object> options) {
        this.tag = tag;
        this.method = "session-set";
        this.arguments = new SolidMap<>(options);
    }

    @Override
    public Map<String, Object> arguments() {
        return arguments;
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public Integer tag() {
        return tag;
    }
}
