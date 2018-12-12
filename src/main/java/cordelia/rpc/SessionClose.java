package cordelia.rpc;

public final class SessionClose implements Req {

    private final String method;
    private final Integer tag;

    public SessionClose(Integer tag) {
        this.tag = tag;
        this.method = "session-close";
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
