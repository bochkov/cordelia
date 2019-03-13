package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.Solid;

public final class RenamePath extends AbsOptReq {

    public RenamePath(Object id, String path, String name) {
        this(5, id, path, name);
    }

    public RenamePath(Integer tag, Object id, String path, String name) {
        super(
                tag,
                "torrent-rename-path",
                new Solid<>(
                        new MapOf<>(
                                new MapEntry<>("path", path),
                                new MapEntry<>("name", name),
                                new MapEntry<>("ids", new ListOf<>(id))
                        )
                )
        );
    }
}
