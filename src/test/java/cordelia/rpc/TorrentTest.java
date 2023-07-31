package cordelia.rpc;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TorrentTest {

    @Test
    void testCtor() {
        OptReq req = new Torrent(11, Torrent.Action.START, 12, 15, 16);
        Assertions.assertThat(req.tag()).isEqualTo(11);
        Assertions.assertThat(req.arguments().get("ids")).isEqualTo(List.of(12, 15, 16));
    }

    @Test
    void testCtorNoArgs() {
        Req req = new Torrent(Torrent.Action.START, 12, 15, 16);
        Assertions.assertThat(req.tag()).isEqualTo(10);
    }

    @Test
    void testCtor2() {
        OptReq req = new Torrent(11, Torrent.Action.START);
        Assertions.assertThat(req.arguments()).isNotNull();
        Assertions.assertThat(req.arguments().get("ids")).isNull();
    }

    @Test
    void testStart() {
        OptReq req = new Torrent(12, Torrent.Action.START);
        Assertions.assertThat(req.method()).isEqualTo("torrent-start");
    }

    @Test
    void testStartNow() {
        OptReq req = new Torrent(12, Torrent.Action.START_NOW);
        Assertions.assertThat(req.method()).isEqualTo("torrent-start-now");
    }

    @Test
    void testStop() {
        OptReq req = new Torrent(12, Torrent.Action.STOP);
        Assertions.assertThat(req.method()).isEqualTo("torrent-stop");
    }

    @Test
    void testVerify() {
        OptReq req = new Torrent(12, Torrent.Action.VERIFY);
        Assertions.assertThat(req.method()).isEqualTo("torrent-verify");
    }

    @Test
    void testReannounce() {
        OptReq req = new Torrent(12, Torrent.Action.REANNOUNCE);
        Assertions.assertThat(req.method()).isEqualTo("torrent-reannounce");
    }
}