package cordelia.jsonrpc.res;

import cordelia.CordeliaConstants;
import cordelia.client.TrClient;
import cordelia.jsonrpc.req.RqSessionGet;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class RsSessionGetTest {

    @Test
    void testGet() {
        TrClient tr = new TrClient(CordeliaConstants.RPC_URL);
        RqSessionGet.Params params = RqSessionGet.Params.builder().build();
        RqSessionGet req = new RqSessionGet(CordeliaConstants.TAG, params);
        RsSessionGet res = tr.execute(req);
        LOG.info("{}", res);
        Assertions.assertThat(res.getResult()).isNotNull();
    }

}