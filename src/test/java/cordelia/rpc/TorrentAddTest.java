package cordelia.rpc;

import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.junit.Assert;
import org.junit.Test;

public class TorrentAddTest {

    @Test
    public void testCtor() {
        OptReq req = new TorrentAdd(4, new MapOf<>(new MapEntry<>("filename", "test")));
        Assert.assertEquals(new Integer(4), req.tag());
        Assert.assertEquals("torrent-add", req.method());
        Assert.assertEquals(
                "test",
                req.arguments().get("filename")
        );
    }

}