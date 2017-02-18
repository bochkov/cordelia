package cordelia.rpc;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class TorrentRemove implements Serializable {

    private final String method = "torrent-remove";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentRemove(Object... ids) {
        this(null, false, ids);
    }

    public TorrentRemove(Boolean withData, Object... ids) {
        this(null, withData, ids);
    }

    public TorrentRemove(Integer tag, Boolean withData, Object... ids) {
        this.tag = tag;
        Map<String, Object> map = new HashMap<>();
        map.put("delete-local-data", withData);
        map.put("ids", Arrays.asList(ids));
        this.arguments = Collections.unmodifiableMap(map);
    }
}
