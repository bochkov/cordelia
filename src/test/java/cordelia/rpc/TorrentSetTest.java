package cordelia.rpc;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TorrentSetTest {

    @Test
    void testCtor() {
        OptReq req = new TorrentSet(12, Map.of("test1", "test2"));
        Assertions.assertThat(req.tag()).isEqualTo(12);
        Assertions.assertThat(req.method()).isEqualTo("torrent-set");
        Assertions.assertThat(req.arguments().get("test1")).isEqualTo("test2");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new TorrentSet(Map.of("test1", "test2"));
        Assertions.assertThat(req.tag()).isEqualTo(15);
    }
}