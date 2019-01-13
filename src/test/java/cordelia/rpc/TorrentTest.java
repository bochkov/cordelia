package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TorrentTest {

    @Test
    public void testCtor() {
        OptReq req = new Torrent(11, Torrent.Action.START, 12, 15, 16);
        Assert.assertEquals(Integer.valueOf(11), req.tag());
        Assert.assertEquals(
                Arrays.asList(12, 15, 16),
                req.arguments().get("ids")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new Torrent(Torrent.Action.START, 12, 15, 16);
        Assert.assertEquals(Integer.valueOf(10), req.tag());
    }

    @Test
    public void testCtor2() {
        OptReq req = new Torrent(11, Torrent.Action.START);
        Assert.assertNotNull(req.arguments());
        Assert.assertNull(req.arguments().get("ids"));
    }

    @Test
    public void testStart() {
        OptReq req = new Torrent(12, Torrent.Action.START);
        Assert.assertEquals(req.method(), "torrent-start");
    }

    @Test
    public void testStartNow() {
        OptReq req = new Torrent(12, Torrent.Action.START_NOW);
        Assert.assertEquals(req.method(), "torrent-start-now");
    }

    @Test
    public void testStop() {
        OptReq req = new Torrent(12, Torrent.Action.STOP);
        Assert.assertEquals(req.method(), "torrent-stop");
    }

    @Test
    public void testVerify() {
        OptReq req = new Torrent(12, Torrent.Action.VERIFY);
        Assert.assertEquals(req.method(), "torrent-verify");
    }

    @Test
    public void testReannounce() {
        OptReq req = new Torrent(12, Torrent.Action.REANNOUNCE);
        Assert.assertEquals(req.method(), "torrent-reannounce");
    }
}