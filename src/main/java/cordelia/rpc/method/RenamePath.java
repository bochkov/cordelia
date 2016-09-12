package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class RenamePath extends Request {

    public static final String METHOD = "torrent-rename-path";

    public RenamePath(String path, String name, Object... ids) {
        this(null, path, name, ids);
    }

    public RenamePath(Integer tag, String path, String name, Object... ids) {
        super(METHOD, tag);
        this.arguments.put("path", path);
        this.arguments.put("name", name);
        this.arguments.put("ids", ids);
    }
}
