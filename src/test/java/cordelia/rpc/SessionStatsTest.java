package cordelia.rpc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionStatsTest {

    @Test
    void testCtor() {
        Req req = new SessionStats(12);
        Assertions.assertThat(req.tag()).isEqualTo(12);
        Assertions.assertThat(req.method()).isEqualTo("session-stats");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new SessionStats();
        Assertions.assertThat(req.tag()).isEqualTo(9);
    }
}