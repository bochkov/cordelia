package cordelia.jsonrpc.req;

/**
 * Start torrent disregarding queue position
 */
public final class RqTorrentStartNow extends RqTorrent {
    public RqTorrentStartNow(Long id, RqTorrent.Params params) {
        super("torrent_start_now", id, params);
    }
}
