package cordelia.rpc;

import java.io.Serializable;

public final class PortCheck implements Serializable {

    private final String method = "port-test";
    private final Integer tag;

    public PortCheck() {
        this(null);
    }

    public PortCheck(Integer tag) {
        this.tag = tag;
    }
}
