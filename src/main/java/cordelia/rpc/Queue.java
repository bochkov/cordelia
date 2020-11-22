package cordelia.rpc;

import java.util.List;
import java.util.Map;

public final class Queue extends AbsOptReq {

    public Queue(To to, Object... ids) {
        this(4, to, ids);
    }

    public Queue(Integer tag, To to, Object... ids) {
        super(
                tag,
                to.method(),
                ids.length > 0 ?
                        Map.of("ids", List.of(ids)) :
                        Map.of()
        );
    }

    public enum To {
        TOP("queue-move-top"),
        UP("queue-move-up"),
        DOWN("queue-move-down"),
        BOTTOM("queue-move-bottom");

        private final String method;

        To(String method) {
            this.method = method;
        }

        public String method() {
            return method;
        }
    }
}
