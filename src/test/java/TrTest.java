import cordelia.client.TrClient;
import cordelia.client.TrResponse;
import cordelia.rpc.SessionGet;
import cordelia.rpc.SessionStats;
import org.junit.Test;

import java.io.IOException;

public class TrTest {

    TrClient client = new TrClient("http://192.168.55.5:9091/transmission/rpc");

    @Test
    public void test() throws IOException {
        System.out.println(
                client.post(new SessionGet())
        );
        System.out.println(
                client.post(new SessionStats(23), TrResponse.class)
        );
    }
}
