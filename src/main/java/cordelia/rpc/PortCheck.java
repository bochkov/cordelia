package cordelia.rpc;

public final class PortCheck implements Req {

    private final String method;
    private final Integer tag;

    public PortCheck() {
        this(3);
    }

    public PortCheck(Integer tag) {
        this.tag = tag;
        this.method = "port-test";
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
