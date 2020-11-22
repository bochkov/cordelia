package cordelia.rpc;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SessionSetTest {

    @Test
    public void testCtor() {
        OptReq req = new SessionSet(9, Map.of("test", "test"));
        Assert.assertEquals(Integer.valueOf(9), req.tag());
        Assert.assertEquals("session-set", req.method());
        Assert.assertEquals(
                "test",
                req.arguments().get("test")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new SessionSet(Map.of("test", "test"));
        Assert.assertEquals(Integer.valueOf(8), req.tag());
    }
}