package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.Solid;

public final class Queue extends AbsOptReq {

    public Queue(To to, Object... ids) {
        this(4, to, ids);
    }

    public Queue(Integer tag, To to, Object... ids) {
        super(
                tag,
                to.method(),
                ids.length > 0 ?
                        new Solid<>(
                                new MapOf<>(
                                        new MapEntry<>("ids", new ListOf<>(ids))
                                )
                        ) :
                        new Solid<>(
                                new MapOf<>()
                        )
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
