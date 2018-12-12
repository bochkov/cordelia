package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

public class BlocklistUpdateTest {

    @Test
    public void testCtor() {
        Req req = new BlocklistUpdate(15);
        Assert.assertEquals(new Integer(15), req.tag());
        Assert.assertEquals("blocklist-update", req.method());
    }
}