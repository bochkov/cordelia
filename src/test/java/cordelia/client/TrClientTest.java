package cordelia.client;

import com.jcabi.http.mock.MkAnswer;
import com.jcabi.http.mock.MkContainer;
import com.jcabi.http.mock.MkGrizzlyContainer;
import cordelia.rpc.SessionGet;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

public class TrClientTest {

    @Test
    public void testRetryWire() throws IOException {
        try (MkContainer container = new MkGrizzlyContainer()) {
            container.next(
                    new MkAnswer.Simple("")
                            .withStatus(HttpURLConnection.HTTP_INTERNAL_ERROR)
            ).next(
                    new MkAnswer.Simple("hello, world!")
                            .withHeader(Session.SESSION_ID, "123456")
                            .withStatus(HttpURLConnection.HTTP_CONFLICT)
            ).next(
                    new MkAnswer.Simple("hello, world")
            );
            container.start();
            Client cl = new TrClient(container.home());
            String str = cl.post(new SessionGet());
            container.stop();
            Assert.assertNotNull(str);
        }
    }

    @Test(expected = IOException.class)
    public void testRetry409Wire() throws IOException {
        try (MkContainer container = new MkGrizzlyContainer()) {
            container.next(
                    new MkAnswer.Simple("")
                            .withStatus(HttpURLConnection.HTTP_INTERNAL_ERROR)
            ).next(
                    new MkAnswer.Simple("hello, world!")
                            .withHeader(Session.SESSION_ID, "123456")
                            .withStatus(HttpURLConnection.HTTP_CONFLICT)
            ).next(
                    new MkAnswer.Simple("hello, world")
                            .withStatus(HttpURLConnection.HTTP_CONFLICT)
            );
            container.start();
            Client cl = new TrClient(container.home());
            cl.post(new SessionGet());
            container.stop();
        }
    }

    @Test
    public void post() throws IOException {
        try (MkContainer container = new MkGrizzlyContainer()) {
            container.next(
                    new MkAnswer.Simple("")
                            .withHeader(Session.SESSION_ID, "5555")
            ).next(
                    new MkAnswer.Simple("")
            );
            container.start();
            Client cl = new TrClient(container.home());
            String answer = cl.post(new SessionGet());
            container.stop();
            Assert.assertEquals("", answer);
        }
    }

    @Test
    public void post1() throws IOException {
        try (MkContainer container = new MkGrizzlyContainer()) {
            container.next(
                    new MkAnswer.Simple("")
                            .withHeader(Session.SESSION_ID, "5555")
            ).next(
                    new MkAnswer.Simple("{\"ddd\": \"ttt\"}")
            );
            container.start();
            Client cl = new TrClient(container.home());
            TestFreeSpaceRes answer = cl.post(new TestFreeSpaceReq(), TestFreeSpaceRes.class);
            container.stop();
            Assert.assertNotNull(answer);
        }
    }
}