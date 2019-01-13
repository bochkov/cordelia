package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.SolidMap;

import java.util.Map;

public final class TorrentRemove implements OptReq {

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentRemove(Boolean withData, Object... ids) {
        this(14, withData, ids);
    }

    public TorrentRemove(Integer tag, Boolean withData, Object... ids) {
        this.tag = tag;
        this.method = "torrent-remove";
        this.arguments = ids.length > 0 ?
                new SolidMap<>(
                        new MapOf<>(
                                new MapEntry<>("delete-local-data", withData),
                                new MapEntry<>("ids", new ListOf<>(ids))
                        )
                ) :
                new SolidMap<>(
                        new MapOf<>(
                                new MapEntry<>("delete-local-data", withData)
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
