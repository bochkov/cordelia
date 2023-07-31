package cordelia.rpc;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TorrentRemoveTest {

    @Test
    void testCtor() {
        OptReq req = new TorrentRemove(12, true, 4, 5, 6);
        Assertions.assertThat(req.tag()).isEqualTo(12);
        Assertions.assertThat(req.method()).isEqualTo("torrent-remove");
        Assertions.assertThat(req.arguments().get("delete-local-data")).isEqualTo(Boolean.TRUE);
        Assertions.assertThat(req.arguments().get("ids")).isEqualTo(List.of(4, 5, 6));
    }

    @Test
    void testCtorNoArgs() {
        Req req = new TorrentRemove(true, 4, 5, 6);
        Assertions.assertThat(req.tag()).isEqualTo(14);
    }
}