package cordelia.rpc;

import com.google.api.client.util.Key;

import java.util.Map;

public final class Response {

    /**
     * A required "result" string whose value MUST be "success" on success, or an error string on failure.
     */
    @Key
    private String result;

    /**
     * An optional "arguments" object of key/value pairs
     */
    @Key
    private Map<String, Object> arguments;

    /**
     * An optional "tag" number
     */
    @Key
    private Integer tag;

    public boolean success() {
        return "success".equals(result);
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

    @Override
    public String toString() {
        return "Response {" +
                "result='" + result + '\'' +
                ", arguments=" + arguments +
                ", tag=" + tag +
                '}';
    }
}
