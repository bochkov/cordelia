package cordelia.client;

import java.util.Map;

public final class TrResponse {

    private String result;
    private Map<String, Object> arguments;
    private String tag;

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
        return "Response {" +
                "result='" + result + '\'' +
                ", arguments=" + arguments +
                ", tag=" + tag +
                '}';
    }
}
