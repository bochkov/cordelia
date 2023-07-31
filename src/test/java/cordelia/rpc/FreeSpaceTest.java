package cordelia.rpc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FreeSpaceTest {

    @Test
    void testCtor() {
        OptReq req = new FreeSpace(12, "/tmp");
        Assertions.assertThat(req.method()).isEqualTo("free-space");
        Assertions.assertThat(req.tag()).isEqualTo(12);
        Assertions.assertThat(req.arguments().get("path")).isEqualTo("/tmp");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new FreeSpace("/tmp");
        Assertions.assertThat(req.tag()).isEqualTo(2);
    }
}