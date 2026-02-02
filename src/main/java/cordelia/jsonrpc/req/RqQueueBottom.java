package cordelia.jsonrpc.req;

public final class RqQueueBottom extends RqQueue {
    public RqQueueBottom(Long id, Params params) {
        super("queue_move_bottom", id, params);
    }
}
