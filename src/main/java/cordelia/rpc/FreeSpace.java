package cordelia.rpc;

import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

import java.io.Serializable;
import java.util.Map;

public final class FreeSpace implements Serializable {

    private final String method = "free-space";
    private final Integer tag;
    private final Map<String, String> arguments;

    public FreeSpace(String path) {
        this(null, path);
    }

    public FreeSpace(Integer tag, String path) {
        this.tag = tag;
        this.arguments = new MapOf<String, String>(
                new MapEntry<>("path", path)
        );
    }
}
