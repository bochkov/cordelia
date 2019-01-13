package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class BlocklistUpdateTest {

    @Test
    public void testCtor() {
        Req req = new BlocklistUpdate(15);
        Assert.assertEquals(Integer.valueOf(15), req.tag());
        Assert.assertEquals("blocklist-update", req.method());
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new BlocklistUpdate();
        Assert.assertEquals(Integer.valueOf(1), req.tag());
    }
}