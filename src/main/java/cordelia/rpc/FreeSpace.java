package cordelia.rpc;

import java.util.Map;

public final class FreeSpace extends AbsOptReq {

    public FreeSpace(String path) {
        this(2, path);
    }

    public FreeSpace(Integer tag, String path) {
        super(
                tag,
                "free-space",
                Map.of("path", path)
        );
    }
}
