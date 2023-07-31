package cordelia.rpc;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TorrentAddTest {

    @Test
    void testCtor() {
        OptReq req = new TorrentAdd(4, Map.of("filename", "test"));
        Assertions.assertThat(req.tag()).isEqualTo(4);
        Assertions.assertThat(req.method()).isEqualTo("torrent-add");
        Assertions.assertThat(req.arguments().get("filename")).isEqualTo("test");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new TorrentAdd(Map.of("filename", "test"));
        Assertions.assertThat(req.tag()).isEqualTo(11);
    }
}