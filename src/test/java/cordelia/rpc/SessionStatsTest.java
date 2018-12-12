package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class SessionStatsTest {

    @Test
    public void testCtor() {
        Req req = new SessionStats(12);
        Assert.assertEquals(new Integer(12), req.tag());
        Assert.assertEquals("session-stats", req.method());
    }
}