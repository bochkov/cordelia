package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class BlocklistUpdate extends Request {

    public static final String METHOD = "blocklist-update";

    public BlocklistUpdate() {
        this(null);
    }

    public BlocklistUpdate(Integer tag) {
        super(null, tag);
    }
}
