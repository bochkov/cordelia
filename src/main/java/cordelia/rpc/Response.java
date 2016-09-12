package cordelia.rpc;

import com.google.api.client.util.Key;

import java.util.Map;

public final class Response {

    @Key("result")
    private String result;
    @Key("arguments")
    private Map<String, Object> arguments;
    @Key("tag")
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
