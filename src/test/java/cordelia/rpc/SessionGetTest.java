package cordelia.rpc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionGetTest {

    @Test
    void testCtor() {
        Req req = new SessionGet(14);
        Assertions.assertThat(req.tag()).isEqualTo(14);
        Assertions.assertThat(req.method()).isEqualTo("session-get");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new SessionGet();
        Assertions.assertThat(req.tag()).isEqualTo(7);
    }
}