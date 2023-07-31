package cordelia.rpc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BlocklistUpdateTest {

    @Test
    void testCtor() {
        Req req = new BlocklistUpdate(15);
        Assertions.assertThat(req.tag()).isEqualTo(15);
        Assertions.assertThat(req.method()).isEqualTo("blocklist-update");
    }

    @Test
    void testCtorNoArgs() {
        Req req = new BlocklistUpdate();
        Assertions.assertThat(req.tag()).isEqualTo(1);
    }
}