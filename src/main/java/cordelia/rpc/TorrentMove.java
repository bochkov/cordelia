package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

import java.io.Serializable;
import java.util.Map;

public final class TorrentMove implements Serializable {

    private final String method = "torrent-set-location";
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentMove(String location, Boolean move, Object... ids) {
        this(null, location, move, ids);
    }

    public TorrentMove(Integer tag, String location, Boolean move, Object... ids) {
        this.tag = tag;
        this.arguments = ids.length > 0 ?
                new MapOf<>(
                        new MapEntry<>("location", location),
                        new MapEntry<>("move", move),
                        new MapEntry<>("ids", new ListOf<>(ids))
                ) :
                new MapOf<>(
                        new MapEntry<>("location", location),
                        new MapEntry<>("move", move)
                );
    }
}
