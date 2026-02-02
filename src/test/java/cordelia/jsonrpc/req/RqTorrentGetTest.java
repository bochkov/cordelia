package cordelia.jsonrpc.req;

import cordelia.CordeliaConstants;
import cordelia.client.TrClient;
import cordelia.jsonrpc.res.RsTorrentGet;
import cordelia.jsonrpc.types.FKey;
import kong.unirest.core.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class RqTorrentGetTest {

    @Test
    void test() {
        RqTorrentGet.Params params = RqTorrentGet.Params.builder()
                .fields(List.of(FKey.NAME, FKey.HASH_STRING))
                .build();
        RqTorrentGet req = new RqTorrentGet(CordeliaConstants.TAG, params);
        TrClient tr = new TrClient(CordeliaConstants.RPC_URL);
        LOG.info("{}", tr.om().writeValue(req));
        RsTorrentGet res = tr.execute(req);
        LOG.info("{}", res.getResult().getTorrents());
        Assertions.assertThat(res.getResult()).isNotNull();
    }

    @Test
    void testRaw() {
        ObjectMapper om = new TrClient(CordeliaConstants.RPC_URL).om();
        RqTorrentGet.Params params = RqTorrentGet.Params.builder()
                .fields(List.of(FKey.NAME, FKey.HASH_STRING))
                .build();
        RqTorrentGet req = new RqTorrentGet(CordeliaConstants.TAG, params);
        LOG.debug("{}", om.writeValue(req));
        new TrClient(CordeliaConstants.RPC_URL).execute(req);
    }

}