package cordelia.jsonrpc.req;

/**
 * Verify torrent
 */
public final class RqTorrentVerify extends RqTorrent {
    public RqTorrentVerify(Long id, RqTorrent.Params params) {
        super("torrent-verify", id, params);
    }
}
