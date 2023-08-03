package cordelia.rpc;

import java.util.List;

import lombok.RequiredArgsConstructor;

@ReqMethod(value = "torrent-rename-path", answer = RsTorrentRename.class)
@RequiredArgsConstructor
public final class RqTorrentRename implements RqArguments {

    private final List<Object> ids;
    private final String path;
    private final String name;

}
