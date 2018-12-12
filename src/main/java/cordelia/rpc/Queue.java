package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.SolidMap;

import java.util.Map;

public final class Queue implements OptReq {

    private final Integer tag;
    private final String method;
    private final Map<String, Object> arguments;

    public Queue(To to, Object... ids) {
        this(null, to, ids);
    }

    public Queue(Integer tag, To to, Object... ids) {
        this.tag = tag;
        this.method = to.method();
        this.arguments = ids.length > 0 ?
                new SolidMap<>(
                        new MapOf<>(
                                new MapEntry<>("ids", new ListOf<>(ids))
                        )
                ) :
                new SolidMap<>(
                        new MapOf<>()
                );
    }

    @Override
    public Map<String, Object> arguments() {
        return arguments;
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public Integer tag() {
        return tag;
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
