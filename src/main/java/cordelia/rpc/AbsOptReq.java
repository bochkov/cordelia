package cordelia.rpc;

import java.util.Map;

public abstract class AbsOptReq extends AbsReq implements OptReq {

    protected final transient Map<String, Object> arguments;

    public AbsOptReq(Integer tag, String method, Map<String, Object> args) {
        super(tag, method);
        this.arguments = args;
    }

    @Override
    public Map<String, Object> arguments() {
        return arguments;
    }
}
