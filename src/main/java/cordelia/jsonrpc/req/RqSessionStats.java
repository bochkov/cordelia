package cordelia.jsonrpc.req;

import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsSessionStats;

public final class RqSessionStats extends RpcRequest<RsSessionStats> {
    public RqSessionStats(Long id) {
        super("session_stats", id);
    }
}
