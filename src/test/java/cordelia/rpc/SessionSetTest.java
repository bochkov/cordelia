package cordelia.rpc;

import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.junit.Assert;
import org.junit.Test;

public class SessionSetTest {

    @Test
    public void testCtor() {
        OptReq req = new SessionSet(9, new MapOf<>(new MapEntry<>("test", "test")));
        Assert.assertEquals(new Integer(9), req.tag());
        Assert.assertEquals("session-set", req.method());
        Assert.assertEquals(
                "test",
                req.arguments().get("test")
        );
    }
}