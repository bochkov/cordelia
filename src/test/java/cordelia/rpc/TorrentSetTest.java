package cordelia.rpc;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TorrentSetTest {

    @Test
    public void testCtor() {
        OptReq req = new TorrentSet(12, Map.of("test1", "test2"));
        Assert.assertEquals(Integer.valueOf(12), req.tag());
        Assert.assertEquals("torrent-set", req.method());
        Assert.assertEquals(
                "test2",
                req.arguments().get("test1")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new TorrentSet(Map.of("test1", "test2"));
        Assert.assertEquals(Integer.valueOf(15), req.tag());
    }
}