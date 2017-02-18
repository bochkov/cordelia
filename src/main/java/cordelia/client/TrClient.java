package cordelia.client;

import com.google.gson.Gson;
import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.wire.BasicAuthWire;
import com.jcabi.http.wire.RetryWire;

import java.io.IOException;
import java.io.Serializable;

public final class TrClient {

    private final String url;
    private Session cachedSession;

    public TrClient(String url) {
        this.url = url;
    }

    private Session session() throws IOException {
        if (cachedSession == null)
            cachedSession = new Session(
                new JdkRequest(url)
                        .method(Request.POST)
                        .header("Content-Type", "application/json")
                        .through(BasicAuthWire.class)
                        .through(RetryWire.class)
                        .body().back()
                        .fetch()
                        .headers()
                        .get(Session.SESSION).get(0));
        return cachedSession;
    }

    public String post(Serializable serializable) throws IOException {
        return new JdkRequest(url)
                .method(Request.POST)
                .header("Content-Type", "application/json")
                .through(BasicAuthWire.class)
                .through(SessionWire.class, session())
                .through(Retry409Wire.class)
                .through(RetryWire.class)
                .body()
                .set(new Gson().toJson(serializable))
                .back()
                .fetch()
                .body();
    }

    public <T> T post(Serializable serializable, Class<T> type) throws IOException {
        return new JdkRequest(url)
                .method(Request.POST)
                .header("Content-Type", "application/json")
                .through(BasicAuthWire.class)
                .through(SessionWire.class, session())
                .through(Retry409Wire.class)
                .through(RetryWire.class)
                .body()
                .set(new Gson().toJson(serializable))
                .back()
                .fetch()
                .as(GsonResponse.class)
                .json(type);
    }
}
