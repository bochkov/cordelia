package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TorrentGetTest {

    @Test
    public void testCtor() {
        OptReq req = new TorrentGet(1, Arrays.asList("field1", "field2"), 10, 11, 12);
        Assert.assertEquals(Integer.valueOf(1), req.tag());
        Assert.assertEquals("torrent-get", req.method());
        Assert.assertEquals(
                Arrays.asList("field1", "field2"),
                req.arguments().get("fields")
        );
        Assert.assertEquals(
                Arrays.asList(10, 11, 12),
                req.arguments().get("ids")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new TorrentGet(Arrays.asList("field1", "field2"), 10, 11, 12);
        Assert.assertEquals(Integer.valueOf(12), req.tag());
    }
}