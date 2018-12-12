package cordelia.rpc;

public final class BlocklistUpdate implements Req {

    private final String method;
    private final Integer tag;

    public BlocklistUpdate(Integer tag) {
        this.tag = tag;
        this.method = "blocklist-update";
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public Integer tag() {
        return tag;
    }
}
