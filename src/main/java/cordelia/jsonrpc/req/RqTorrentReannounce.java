package cordelia.jsonrpc.req;

/**
 * Re-announce to trackers now
 */
public final class RqTorrentReannounce extends RqTorrent {
    public RqTorrentReannounce(Long id, RqTorrent.Params params) {
        super("torrent-reannounce", id, params);
    }
}
