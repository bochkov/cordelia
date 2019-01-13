package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.SolidMap;

import java.util.Map;

public final class TorrentMove implements OptReq {

    private final String method;
    private final Integer tag;
    private final Map<String, Object> arguments;

    public TorrentMove(String location, Boolean move, Object... ids) {
        this(13, location, move, ids);
    }

    public TorrentMove(Integer tag, String location, Boolean move, Object... ids) {
        this.tag = tag;
        this.method = "torrent-set-location";
        this.arguments = ids.length > 0 ?
                new SolidMap<>(
                        new MapOf<>(
                                new MapEntry<>("location", location),
                                new MapEntry<>("move", move),
                                new MapEntry<>("ids", new ListOf<>(ids))
                        )
                ) :
                new SolidMap<>(
                        new MapOf<>(
                                new MapEntry<>("location", location),
                                new MapEntry<>("move", move)
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
