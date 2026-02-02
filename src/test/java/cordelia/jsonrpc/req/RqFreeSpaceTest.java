package cordelia.jsonrpc.req;

import cordelia.CordeliaConstants;
import cordelia.client.TrClient;
import cordelia.jsonrpc.res.RsFreeSpace;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RqFreeSpaceTest {

    @Test
    void test() {
        TrClient client = new TrClient(CordeliaConstants.RPC_URL);
        RqFreeSpace.Params params = RqFreeSpace.Params.builder()
                .path("/")
                .build();
        RqFreeSpace req = new RqFreeSpace(CordeliaConstants.TAG, params);
        RsFreeSpace res = client.execute(req);
        Assertions.assertThat(res.getResult()).isNotNull();
    }

}