package cordelia.rpc;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void testArgs() {
        OptReq req = new Queue(10, Queue.To.TOP, 101, 102, 103);
        Assertions.assertThat(req.tag()).isEqualTo(10);
        Assertions.assertThat(req.arguments().get("ids")).isEqualTo(List.of(101, 102, 103));
    }

    @Test
    void testCtorNoArgs() {
        Req req = new Queue(Queue.To.TOP, 101, 102, 103);
        Assertions.assertThat(req.tag()).isEqualTo(4);
    }

    @Test
    void testEmpty() {
        OptReq req = new Queue(Queue.To.TOP);
        Assertions.assertThat(req.tag()).isNotNull();
        Assertions.assertThat(req.method()).isEqualTo("queue-move-top");
        Assertions.assertThat(req.arguments()).isNotNull();
        Assertions.assertThat(req.arguments().get("ids")).isNull();
    }

    @Test
    void testMethodTop() {
        OptReq req = new Queue(10, Queue.To.TOP, 101, 102, 103);
        Assertions.assertThat(req.method()).isEqualTo("queue-move-top");
    }

    @Test
    void testMethodBottom() {
        OptReq req = new Queue(10, Queue.To.BOTTOM, 101, 102, 103);
        Assertions.assertThat(req.method()).isEqualTo("queue-move-bottom");
    }

    @Test
    void testMethodUp() {
        OptReq req = new Queue(10, Queue.To.UP, 101, 102, 103);
        Assertions.assertThat(req.method()).isEqualTo("queue-move-up");
    }

    @Test
    void testMethodDown() {
        OptReq req = new Queue(10, Queue.To.DOWN, 101, 102, 103);
        Assertions.assertThat(req.method()).isEqualTo("queue-move-down");
    }
}