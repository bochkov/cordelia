package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class SessionCloseTest {

    @Test
    public void testCtor() {
        Req req = new SessionClose(15);
        Assert.assertEquals(Integer.valueOf(15), req.tag());
        Assert.assertEquals("session-close", req.method());
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new SessionClose();
        Assert.assertEquals(Integer.valueOf(6), req.tag());
    }
}