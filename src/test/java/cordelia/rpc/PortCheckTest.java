package cordelia.rpc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PortCheckTest {

    @Test
    void testCtor() {
        Req req = new PortCheck(11);
        Assertions.assertThat(req.tag()).isEqualTo(11);
        Assertions.assertThat(req.method()).isEqualTo("port-test");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new PortCheck();
        Assertions.assertThat(req.tag()).isEqualTo(3);
    }
}