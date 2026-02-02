package cordelia.jsonrpc.req;

public final class RqQueueTop extends RqQueue {
    public RqQueueTop(Long id, Params params) {
        super("queue_move_top", id, params);
    }
}
