package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

import java.io.Serializable;
import java.util.Map;

public final class RenamePath implements Serializable {

    private final String method = "torrent-rename-path";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public RenamePath(Object id, String path, String name) {
        this(null, id, path, name);
    }

    public RenamePath(Integer tag, Object id, String path, String name) {
        this.tag = tag;
        this.arguments = new MapOf<>(
                new MapEntry<>("path", path),
                new MapEntry<>("name", name),
                new MapEntry<>("ids", new ListOf<>(id))
        );
    }
}
