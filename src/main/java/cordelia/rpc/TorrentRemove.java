package cordelia.rpc;

import org.cactoos.list.ListOf;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.cactoos.map.Solid;

public final class TorrentRemove extends AbsOptReq {

    public TorrentRemove(Boolean withData, Object... ids) {
        this(14, withData, ids);
    }

    public TorrentRemove(Integer tag, Boolean withData, Object... ids) {
        super(
                tag,
                "torrent-remove",
                ids.length > 0 ?
                        new Solid<>(
                                new MapOf<>(
                                        new MapEntry<>("delete-local-data", withData),
                                        new MapEntry<>("ids", new ListOf<>(ids))
                                )
                        ) :
                        new Solid<>(
                                new MapOf<>(
                                        new MapEntry<>("delete-local-data", withData)
                                )
                        )
        );
    }
}
