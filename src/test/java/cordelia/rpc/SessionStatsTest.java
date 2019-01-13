package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class SessionStatsTest {

    @Test
    public void testCtor() {
        Req req = new SessionStats(12);
        Assert.assertEquals(Integer.valueOf(12), req.tag());
        Assert.assertEquals("session-stats", req.method());
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new SessionStats();
        Assert.assertEquals(Integer.valueOf(9), req.tag());
    }
}