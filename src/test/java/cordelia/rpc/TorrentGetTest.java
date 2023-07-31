package cordelia.rpc;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TorrentGetTest {

    @Test
    void testCtor() {
        OptReq req = new TorrentGet(1, List.of("field1", "field2"), 10, 11, 12);
        Assertions.assertThat(req.tag()).isEqualTo(1);
        Assertions.assertThat(req.method()).isEqualTo("torrent-get");
        Assertions.assertThat(req.arguments().get("fields")).isEqualTo(List.of("field1", "field2"));
        Assertions.assertThat(req.arguments().get("ids")).isEqualTo(List.of(10, 11, 12));
    }

    @Test
    void testCtorNoArgs() {
        Req req = new TorrentGet(List.of("field1", "field2"), 10, 11, 12);
        Assertions.assertThat(req.tag()).isEqualTo(12);
    }
}