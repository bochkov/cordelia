package cordelia.rpc;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class TorrentMove implements Serializable {

    private final String method = "torrent-set-location";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentMove(String location, Boolean move, Object... ids) {
        this(null, location, move, ids);
    }

    public TorrentMove(Integer tag, String location, Boolean move, Object... ids) {
        this.tag = tag;
        Map<String, Object> map = new HashMap<>();
        map.put("location", location);
        map.put("move", move);
        if (ids.length > 0)
            map.put("ids", Arrays.asList(ids));
        this.arguments = Collections.unmodifiableMap(map);
    }
}
