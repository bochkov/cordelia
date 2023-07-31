package cordelia.rpc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionCloseTest {

    @Test
    void testCtor() {
        Req req = new SessionClose(15);
        Assertions.assertThat(req.tag()).isEqualTo(15);
        Assertions.assertThat(req.method()).isEqualTo("session-close");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new SessionClose();
        Assertions.assertThat(req.tag()).isEqualTo(6);
    }
}