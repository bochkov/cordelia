package cordelia.client;

import cordelia.rpc.FreeSpace;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TrClientTest {

    private static final String URL = "http://10.10.10.10:9091/transmission/rpc";

    @Test
    public void test0() {
        Client client = new TrClient(URL);
        TrResponse response = client.post(new FreeSpace("/storage/sdb/Downloads"), TrResponse.class);
        LOG.info("{}", response.arguments());
    }
}