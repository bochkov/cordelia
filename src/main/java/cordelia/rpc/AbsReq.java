package cordelia.rpc;

public abstract class AbsReq implements Req {

    protected final Integer tag;
    protected final String method;

    protected AbsReq(Integer tag, String method) {
        this.tag = tag;
        this.method = method;
    }

    @Override
    public Integer tag() {
        return tag;
    }

    @Override
    public String method() {
        return method;
    }
}
