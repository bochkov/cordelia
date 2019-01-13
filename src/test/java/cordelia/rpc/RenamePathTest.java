package cordelia.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class RenamePathTest {

    @Test
    public void testCtor() {
        OptReq req = new RenamePath(9, 15, "/tmp/dest", "src");
        Assert.assertEquals(Integer.valueOf(9), req.tag());
        Assert.assertEquals("torrent-rename-path", req.method());
        Assert.assertEquals(
                Collections.singletonList(15),
                req.arguments().get("ids")
        );
        Assert.assertEquals(
                "/tmp/dest",
                req.arguments().get("path")
        );
        Assert.assertEquals(
                "src",
                req.arguments().get("name")
        );
    }

    @Test
    public void testCtorNoArgs() {
        Req req = new RenamePath(15, "/tmp/dest", "src");
        Assert.assertEquals(Integer.valueOf(5), req.tag());
    }
}