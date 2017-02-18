package cordelia.rpc;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FreeSpace implements Serializable {

    private final String method = "free-space";
    private final Integer tag;
    private final Map<String, String> arguments;

    public FreeSpace(String path) {
        this(null, path);
    }

    public FreeSpace(Integer tag, String path) {
        this.tag = tag;
        Map<String, String> map = new HashMap<>();
        map.put("path", path);
        this.arguments = Collections.unmodifiableMap(map);
    }
}
