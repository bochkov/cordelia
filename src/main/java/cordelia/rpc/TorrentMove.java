package cordelia.rpc;

import java.util.List;
import java.util.Map;

public final class TorrentMove extends AbsOptReq {

    public TorrentMove(String location, Boolean move, Object... ids) {
        this(13, location, move, ids);
    }

    public TorrentMove(Integer tag, String location, Boolean move, Object... ids) {
        super(
                tag,
                "torrent-set-location",
                ids.length > 0 ?
                        Map.ofEntries(
                                Map.entry("location", location),
                                Map.entry("move", move),
                                Map.entry("ids", List.of(ids))
                        ) :
                        Map.ofEntries(
                                Map.entry("location", location),
                                Map.entry("move", move)
                        )
        );
    }
}
