package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

import java.io.Serializable;
import java.util.Map;

public final class TorrentRemove implements Serializable {

    private final String method = "torrent-remove";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentRemove(Object... ids) {
        this(null, false, ids);
    }

    public TorrentRemove(Boolean withData, Object... ids) {
        this(null, withData, ids);
    }

    public TorrentRemove(Integer tag, Boolean withData, Object... ids) {
        this.tag = tag;
        this.arguments = ids.length > 0 ?
                new MapOf<>(
                        new MapEntry<>("delete-local-data", withData),
                        new MapEntry<>("ids", new ListOf<>(ids))
                ) :
                new MapOf<>(
                        new MapEntry<>("delete-local-data", withData)
                );
    }
}
