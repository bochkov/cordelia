package cordelia.jsonrpc.req;

import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsBlocklistUpdate;

public final class RqBlockListUpdate extends RpcRequest<RsBlocklistUpdate> {

    public RqBlockListUpdate(Long id) {
        super("blocklist_update", id);
    }

}
