package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TorrentMoveTest {

    @Test
    public void testCtor() {
        OptReq req = new TorrentMove(2, "/test/src", true, 10, 11, 12);
        Assert.assertEquals(Integer.valueOf(2), req.tag());
        Assert.assertEquals("torrent-set-location", req.method());
        Assert.assertEquals(
                "/test/src",
                req.arguments().get("location")
        );
        Assert.assertTrue((Boolean) req.arguments().get("move"));
        Assert.assertEquals(
                Arrays.asList(10, 11, 12),
                req.arguments().get("ids")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new TorrentMove("/test/src", true, 10, 11, 12);
        Assert.assertEquals(Integer.valueOf(13), req.tag());
    }
}