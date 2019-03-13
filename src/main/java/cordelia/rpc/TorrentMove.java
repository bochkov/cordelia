package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.Solid;

public final class TorrentMove extends AbsOptReq {

    public TorrentMove(String location, Boolean move, Object... ids) {
        this(13, location, move, ids);
    }

    public TorrentMove(Integer tag, String location, Boolean move, Object... ids) {
        super(
                tag,
                "torrent-set-location",
                ids.length > 0 ?
                        new Solid<>(
                                new MapOf<>(
                                        new MapEntry<>("location", location),
                                        new MapEntry<>("move", move),
                                        new MapEntry<>("ids", new ListOf<>(ids))
                                )
                        ) :
                        new Solid<>(
                                new MapOf<>(
                                        new MapEntry<>("location", location),
                                        new MapEntry<>("move", move)
                                )
                        )
        );
    }
}
