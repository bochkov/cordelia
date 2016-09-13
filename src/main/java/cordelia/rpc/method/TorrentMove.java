package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class TorrentMove extends Request {

    public static final String METHOD = "torrent-set-location";

    public TorrentMove(String location, Boolean move, Object... ids) {
        this(null, location, move, ids);
    }

    public TorrentMove(Integer tag, String location, Boolean move, Object... ids) {
        super(METHOD, tag);
        this.arguments.put("location", location);
        this.arguments.put("move", move);
        if (ids.length != 0)
            this.arguments.put("ids", ids);
    }
}
