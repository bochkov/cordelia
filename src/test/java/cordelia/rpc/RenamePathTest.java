package cordelia.rpc;

import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RenamePathTest {

    @Test
    void testCtor() {
        OptReq req = new RenamePath(9, 15, "/tmp/dest", "src");
        Assertions.assertThat(req.tag()).isEqualTo(9);
        Assertions.assertThat(req.method()).isEqualTo("torrent-rename-path");
        Assertions.assertThat(req.arguments().get("ids")).isEqualTo(Collections.singletonList(15));
        Assertions.assertThat(req.arguments().get("path")).isEqualTo("/tmp/dest");
        Assertions.assertThat(req.arguments().get("name")).isEqualTo("src");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new RenamePath(15, "/tmp/dest", "src");
        Assertions.assertThat(req.tag()).isEqualTo(5);
    }
}