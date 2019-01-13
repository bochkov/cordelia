package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class SessionGetTest {

    @Test
    public void testCtor() {
        Req req = new SessionGet(14);
        Assert.assertEquals(Integer.valueOf(14), req.tag());
        Assert.assertEquals("session-get", req.method());
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new SessionGet();
        Assert.assertEquals(Integer.valueOf(7), req.tag());
    }
}