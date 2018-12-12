package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class FreeSpaceTest {

    @Test
    public void testCtor() {
        OptReq req = new FreeSpace(12, "/tmp");
        Assert.assertEquals("free-space", req.method());
        Assert.assertEquals(new Integer(12), req.tag());
        Assert.assertEquals(
                "/tmp",
                req.arguments().get("path")
        );
    }
}