package cordelia.rpc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@ReqMethod("torrent-remove")
@RequiredArgsConstructor
public final class RqTorrentRemove implements RqArguments {

    private final List<Object> ids;
    @JsonProperty("delete-local-data")
    private final boolean deleteLocalData;

    public RqTorrentRemove(List<Object> ids) {
        this(ids, false);
    }

}
