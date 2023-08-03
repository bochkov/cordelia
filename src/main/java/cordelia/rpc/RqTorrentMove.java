package cordelia.rpc;

import java.util.List;

import lombok.RequiredArgsConstructor;

@ReqMethod("torrent-move")
@RequiredArgsConstructor
public final class RqTorrentMove implements RqArguments {

    private final List<Object> ids;
    private final String location;
    private final boolean move;

    public RqTorrentMove(List<Object> ids, String location) {
        this(ids, location, false);
    }

}
