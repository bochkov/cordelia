package cordelia.rpc;

import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.Solid;

public final class FreeSpace extends AbsOptReq {

    public FreeSpace(String path) {
        this(2, path);
    }

    public FreeSpace(Integer tag, String path) {
        super(
                tag,
                "free-space",
                new Solid<>(
                        new MapOf<>(
                                new MapEntry<>("path", path)
                        )
                )
        );
    }
}
