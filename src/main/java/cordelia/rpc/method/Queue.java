package cordelia.rpc.method;

import cordelia.rpc.Request;

public final class Queue extends Request {

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

    public Queue(To to, Object... ids) {
        this(null, to, ids);
    }

    public Queue(Integer tag, To to, Object... ids) {
        super(to.method(), tag);
        if (ids.length != 0)
            this.arguments.put("ids", ids);
    }

}
