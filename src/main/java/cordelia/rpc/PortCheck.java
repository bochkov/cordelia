package cordelia.rpc;

public final class PortCheck extends AbsReq {

    public PortCheck() {
        this(3);
    }

    public PortCheck(Integer tag) {
        super(tag, "port-test");
    }
}
