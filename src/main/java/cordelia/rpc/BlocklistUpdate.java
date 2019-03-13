package cordelia.rpc;

public final class BlocklistUpdate extends AbsReq {

    public BlocklistUpdate() {
        this(1);
    }

    public BlocklistUpdate(Integer tag) {
        super(tag, "blocklist-update");
    }
}
