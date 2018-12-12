package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QueueTest {

    @Test
    public void testArgs() {
        OptReq req = new Queue(10, Queue.To.TOP, 101, 102, 103);
        Assert.assertEquals(new Integer(10), req.tag());
        Assert.assertEquals(
                Arrays.asList(101, 102, 103),
                req.arguments().get("ids")
        );
    }

    @Test
    public void testEmpty() {
        OptReq req = new Queue(Queue.To.TOP);
        Assert.assertNull(req.tag());
        Assert.assertEquals("queue-move-top", req.method());
        Assert.assertNotNull(req.arguments());
        Assert.assertNull(req.arguments().get("ids"));
    }

    @Test
    public void testMethodTop() {
        OptReq req = new Queue(10, Queue.To.TOP, 101, 102, 103);
        Assert.assertEquals("queue-move-top", req.method());
    }

    @Test
    public void testMethodBottom() {
        OptReq req = new Queue(10, Queue.To.BOTTOM, 101, 102, 103);
        Assert.assertEquals("queue-move-bottom", req.method());
    }

    @Test
    public void testMethodUp() {
        OptReq req = new Queue(10, Queue.To.UP, 101, 102, 103);
        Assert.assertEquals("queue-move-up", req.method());
    }

    @Test
    public void testMethodDown() {
        OptReq req = new Queue(10, Queue.To.DOWN, 101, 102, 103);
        Assert.assertEquals("queue-move-down", req.method());
    }
}