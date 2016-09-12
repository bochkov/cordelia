package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class FreeSpace extends Request {

    public static final String METHOD = "free-space";

    public FreeSpace(String path) {
        this(null, path);
    }

    public FreeSpace(Integer tag, String path) {
        super(METHOD, tag);
        this.arguments.put("path", path);
    }
}
