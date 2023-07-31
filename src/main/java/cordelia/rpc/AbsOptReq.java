package cordelia.rpc;

import java.util.Collections;
import java.util.Map;

public abstract class AbsOptReq extends AbsReq implements OptReq {

    protected final Map<String, Object> arguments;

    protected AbsOptReq(Integer tag, String method, Map<String, Object> args) {
        super(tag, method);
        this.arguments = Collections.unmodifiableMap(args);
    }

    @Override
    public Map<String, Object> arguments() {
        return arguments;
    }
}
