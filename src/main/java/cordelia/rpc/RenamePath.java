package cordelia.rpc;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class RenamePath implements Serializable {

    private final String method = "torrent-rename-path";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public RenamePath(Object id, String path, String name) {
        this(null, id, path, name);
    }

    public RenamePath(Integer tag, Object id, String path, String name) {
        this.tag = tag;
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        map.put("name", name);
        map.put("ids", Collections.singletonList(id));
        this.arguments = Collections.unmodifiableMap(map);
    }
}
