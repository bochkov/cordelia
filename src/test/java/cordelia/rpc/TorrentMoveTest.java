package cordelia.rpc;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TorrentMoveTest {

    @Test
    void testCtor() {
        OptReq req = new TorrentMove(2, "/test/src", true, 10, 11, 12);
        Assertions.assertThat(req.tag()).isEqualTo(2);
        Assertions.assertThat(req.method()).isEqualTo("torrent-set-location");
        Assertions.assertThat(req.arguments().get("location")).isEqualTo("/test/src");
        Assertions.assertThat(req.arguments().get("move")).isEqualTo(Boolean.TRUE);
        Assertions.assertThat(req.arguments().get("ids")).isEqualTo(List.of(10, 11, 12));
    }

    @Test
    void testCtorNoArgs() {
        Req req = new TorrentMove("/test/src", true, 10, 11, 12);
        Assertions.assertThat(req.tag()).isEqualTo(13);
    }
}