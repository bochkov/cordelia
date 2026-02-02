package cordelia.jsonrpc.req;

import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsEmpty;

public final class RqSessionClose extends RpcRequest<RsEmpty> {
    public RqSessionClose(Long id) {
        super("session_close", id);
    }
}
