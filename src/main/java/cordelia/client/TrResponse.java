package cordelia.client;

import java.util.HashMap;
import java.util.Map;

public final class TrResponse {

    private final String result;
    private final Map<String, Object> arguments;
    private final String tag;

    public TrResponse(String tag, String result, Map<String, Object> arguments) {
        this.tag = tag;
        this.result = result;
        this.arguments = new HashMap<>(arguments);
    }

    public String result() {
        return result;
    }

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

    public String tag() {
        return tag;
    }

    @Override
    public String toString() {
        return String.format(
                "TrResponse {result='%s', arguments=%s, tag=%s}",
                result, arguments, tag
        );
    }
}
