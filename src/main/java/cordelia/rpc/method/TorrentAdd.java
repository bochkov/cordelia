package cordelia.rpc.method;

import cordelia.rpc.Request;

import java.util.Map;

public final class TorrentAdd extends Request {

    public static final String METHOD = "torrent-add";

    public TorrentAdd(Map<String, Object> options) {
        this(null, options);
    }

    public TorrentAdd(Integer tag, Map<String, Object> options) {
        super(METHOD, tag);
        this.arguments.putAll(options);
    }
}
