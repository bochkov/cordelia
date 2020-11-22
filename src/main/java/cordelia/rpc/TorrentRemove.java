package cordelia.rpc;

import java.util.List;
import java.util.Map;

public final class TorrentRemove extends AbsOptReq {

    public TorrentRemove(Boolean withData, Object... ids) {
        this(14, withData, ids);
    }

    public TorrentRemove(Integer tag, Boolean withData, Object... ids) {
        super(
                tag,
                "torrent-remove",
                ids.length > 0 ?
                        Map.ofEntries(
                                Map.entry("delete-local-data", withData),
                                Map.entry("ids", List.of(ids))
                        ) :
                        Map.of("delete-local-data", withData)
        );
    }
}
