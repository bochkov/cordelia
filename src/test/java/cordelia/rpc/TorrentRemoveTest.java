package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TorrentRemoveTest {

    @Test
    public void testCtor() {
        OptReq req = new TorrentRemove(12, true, 4, 5, 6);
        Assert.assertEquals(Integer.valueOf(12), req.tag());
        Assert.assertEquals("torrent-remove", req.method());
        Assert.assertTrue((Boolean) req.arguments().get("delete-local-data"));
        Assert.assertEquals(
                Arrays.asList(4, 5, 6),
                req.arguments().get("ids")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new TorrentRemove(true, 4, 5, 6);
        Assert.assertEquals(Integer.valueOf(14), req.tag());
    }
}