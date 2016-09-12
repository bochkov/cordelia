package cordelia.rpc.method;

import cordelia.rpc.Request;

import java.util.List;

public final class TorrentGet extends Request {

    public static final String METHOD = "torrent-get";

    public TorrentGet(List<String> fields, Object... ids) {
        this(null, fields, ids);
    }

    public TorrentGet(Integer tag, List<String> fields, Object... ids) {
        super(METHOD, tag);
        this.arguments.put("fields", fields);
        this.arguments.put("ids", ids);
    }
}
