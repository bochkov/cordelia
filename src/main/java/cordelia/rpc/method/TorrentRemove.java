package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class TorrentRemove extends Request {

    public static final String METHOD = "torrent-remove";

    public TorrentRemove(Object... ids) {
        this(null, false, ids);
    }

    public TorrentRemove(Integer tag, Object... ids) {
        this(tag, false, ids);
    }

    public TorrentRemove(Integer tag, Boolean withData, Object... ids) {
        super(METHOD, tag);
        this.arguments.put("ids", ids);
        this.arguments.put("delete-local-data", withData);
    }
}
