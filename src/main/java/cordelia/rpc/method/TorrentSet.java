package cordelia.rpc.method;

import cordelia.rpc.Request;

import java.util.Map;

public final class TorrentSet extends Request {

    public static final String METHOD = "torrent-set";

    public TorrentSet(Map<String, Object> options) {
        this(null, options);
    }

    public TorrentSet(Integer tag, Map<String, Object> options) {
        super(METHOD, tag);
        this.arguments.putAll(options);
    }
}
