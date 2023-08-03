package cordelia.client;

import java.util.List;

import cordelia.rpc.*;
import cordelia.rpc.types.Fields;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
class TrClientTest {

    private static TrClient client;

    @BeforeAll
    public static void setUp() {
        client = new TrClient("http://10.10.10.10:9091/transmission/rpc");
    }

    @AfterAll
    public static void tearDown() {
        if (client != null)
            client.shutdown();
    }

    @Test
    void test() {
        RqFreeSpace req = new RqFreeSpace("/storage/sdb/Downloads");
        TypedResponse<RsFreeSpace> rsp = client.execute(req, 155225L);
        Assertions.assertThat(rsp.getArgs()).isNotNull();
        LOG.info(rsp.toString());

        TypedResponse<RsSessionStats> sss = client.execute(new RqSessionStats());
        LOG.info(sss.getArgs().toString());
    }

    @Test
    void test2() {
        RqTorrentSet req = RqTorrentSet.builder()
                .ids(List.of(1, 2, 3))
                .bandwidthPriority(1)
                .uploadLimited(Boolean.FALSE)
                .downloadLimited(Boolean.FALSE)
                .build();
        TypedResponse<RsEmpty> rsp = client.execute(req);
        Assertions.assertThat(rsp.getArgs()).isNotNull();
        LOG.info(rsp.getArgs().toString());
    }

    @Test
    void test4() {
        TypedResponse<RsPortCheck> post = client.execute(new RqPortCheck());
        Assertions.assertThat(post).isNotNull();
        LOG.info(post.toString());
    }

    @Test
    void test3() {
        RqSessionGet req = new RqSessionGet();
        TypedResponse<RsSessionGet> rsp = client.execute(req);
        Assertions.assertThat(rsp.getArgs()).isNotNull();
        LOG.info(rsp.getArgs().toString());
    }

    @Test
    void test5() {
        RqTorrentGet req = new RqTorrentGet(
                Fields.ACTIVITY_DATE,
                Fields.PRIMARY_MIME_TYPE,
                Fields.FILES,
                Fields.FILE_STATS,
                Fields.LABELS
        );
        TypedResponse<RsTorrentGet> rsp = client.execute(req, 2323L);
        Assertions.assertThat(rsp.getArgs()).isNotNull();
        LOG.info(rsp.getArgs().toString());
    }
}