package cordelia.rpc;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionSetTest {

    @Test
    void testCtor() {
        OptReq req = new SessionSet(9, Map.of("test", "test"));
        Assertions.assertThat(req.tag()).isEqualTo(9);
        Assertions.assertThat(req.method()).isEqualTo("session-set");
        Assertions.assertThat(req.arguments().get("test")).isEqualTo("test");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new SessionSet(Map.of("test", "test"));
        Assertions.assertThat(req.tag()).isEqualTo(8);
    }
}