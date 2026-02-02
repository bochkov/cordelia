package cordelia.jsonrpc.req;

public final class RqQueueUp extends RqQueue {
    public RqQueueUp(Long id, Params params) {
        super("queue_move_up", id, params);
    }
}
