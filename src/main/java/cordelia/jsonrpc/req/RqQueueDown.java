package cordelia.jsonrpc.req;

public final class RqQueueDown extends RqQueue {
    public RqQueueDown(Long id, Params params) {
        super("queue_move_down", id, params);
    }
}
