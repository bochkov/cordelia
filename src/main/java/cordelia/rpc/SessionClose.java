package cordelia.rpc;

public final class SessionClose extends AbsReq {

    public SessionClose() {
        this(6);
    }

    public SessionClose(Integer tag) {
        super(tag, "session-close");
    }
}
