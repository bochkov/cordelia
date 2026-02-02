package cordelia.jsonrpc.req;

/**
 * Start torrent
 */
public final class RqTorrentStart extends RqTorrent {
    public RqTorrentStart(Long id, RqTorrent.Params params) {
        super("torrent_start", id, params);
    }
}
