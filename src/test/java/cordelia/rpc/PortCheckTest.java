package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class PortCheckTest {

    @Test
    public void testCtor() {
        Req req = new PortCheck(11);
        Assert.assertEquals(Integer.valueOf(11), req.tag());
        Assert.assertEquals("port-test", req.method());
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new PortCheck();
        Assert.assertEquals(Integer.valueOf(3), req.tag());
    }
}