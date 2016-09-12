package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class PortCheck extends Request {

    public static final String METHOD = "port-test";

    public PortCheck() {
        this(null);
    }

    public PortCheck(Integer tag) {
        super(METHOD, tag);
    }
}
