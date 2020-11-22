package cordelia.rpc;

import java.util.List;
import java.util.Map;

public final class RenamePath extends AbsOptReq {

    public RenamePath(Object id, String path, String name) {
        this(5, id, path, name);
    }

    public RenamePath(Integer tag, Object id, String path, String name) {
        super(
                tag,
                "torrent-rename-path",
                Map.ofEntries(
                        Map.entry("path", path),
                        Map.entry("name", name),
                        Map.entry("ids", List.of(id))
                )
        );
    }
}
