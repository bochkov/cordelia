package cordelia.jsonrpc.req;

/**
 * Stop torrent
 */
public final class RqTorrentStop extends RqTorrent {
    public RqTorrentStop(Long id, RqTorrent.Params params) {
        super("torrent_stop", id, params);
    }
}
