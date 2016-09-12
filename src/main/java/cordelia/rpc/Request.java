package cordelia.rpc;

import com.google.api.client.util.Key;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Request implements Serializable {

    /**
     * A required "method" string telling the name of the method to invoke
     */
    @Key
    protected final String method;

    /**
     * An optional "arguments" object of key/value pairs
     */
    @Key
    protected final Map<String, Object> arguments = new HashMap<>();

    /**
     * An optional "tag" number used by clients to track responses.
     * If provided by a request, the response MUST include the same tag.
     */
    @Key
    protected final Integer tag;

    public Request(String method, Integer tag) {
        this.method = method;
        this.tag = tag;
    }

    public String method() {
        return method;
    }

    public Map<String, Object> arguments() {
        return arguments;
    }

    public Object get(String key) {
        return arguments.get(key);
    }

    public Object get(String key, Object defaultValue) {
        return arguments.getOrDefault(key, defaultValue);
    }

    public Integer tag() {
        return tag;
    }

}
