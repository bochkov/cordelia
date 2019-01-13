package cordelia.rpc;

import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.SolidMap;

import java.util.Map;

public final class FreeSpace implements OptReq {

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public FreeSpace(String path) {
        this(2, path);
    }

    public FreeSpace(Integer tag, String path) {
        this.method = "free-space";
        this.tag = tag;
        this.arguments = new SolidMap<>(
                new MapOf<>(
                        new MapEntry<>("path", path)
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
