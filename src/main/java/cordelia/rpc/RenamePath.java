package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.Solid;

import java.util.Map;

public final class RenamePath implements OptReq {

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public RenamePath(Object id, String path, String name) {
        this(5, id, path, name);
    }

    public RenamePath(Integer tag, Object id, String path, String name) {
        this.tag = tag;
        this.method = "torrent-rename-path";
        this.arguments = new Solid<>(
                new MapOf<>(
                        new MapEntry<>("path", path),
                        new MapEntry<>("name", name),
                        new MapEntry<>("ids", new ListOf<>(id))
                )
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
}
