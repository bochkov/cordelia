package cordelia.rpc;

import java.io.Serializable;

public final class BlocklistUpdate implements Serializable {

    private final String method = "blocklist-update";
    private final Integer tag;

    public BlocklistUpdate() {
        this(null);
    }

    public BlocklistUpdate(Integer tag) {
        this.tag = tag;
    }
}
