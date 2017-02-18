package cordelia.rpc;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Queue implements Serializable {

    public enum To {
        TOP("queue-move-top"),
        UP("queue-move-up"),
        DOWN("queue-move-down"),
        BOTTOM("queue-move-bottom");

        private final String method;

        public String method() {
            return method;
        }

        To(String method) {
            this.method = method;
        }
    }

    private final Integer tag;
    private final String method;
    private final Map<String, Object> arguments;

    public Queue(To to, Object... ids) {
        this(null, to, ids);
    }

    public Queue(Integer tag, To to, Object... ids) {
        this.tag = tag;
        this.method = to.method();
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        this.arguments = Collections.unmodifiableMap(map);
    }
}
