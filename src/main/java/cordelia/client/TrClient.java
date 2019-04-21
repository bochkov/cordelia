package cordelia.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcabi.http.Request;
import com.jcabi.http.Response;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.wire.BasicAuthWire;
import com.jcabi.http.wire.RetryWire;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public final class TrClient implements Client {

    public static final Gson GSON = new GsonBuilder().create();

    private final URI uri;
    private final List<Session> cachedSession = new ArrayList<>();

    public TrClient(String url) {
        this(URI.create(url));
    }

    public TrClient(URI uri) {
        this.uri = uri;
    }

    private Session session() throws IOException {
        if (cachedSession.isEmpty())
            cachedSession.add(
                    new Session(
                            new JdkRequest(uri)
                                    .method(Request.POST)
                                    .header("Content-Type", "application/json")
                                    .through(BasicAuthWire.class)
                                    .through(RetryWire.class)
                                    .body()
                                    .back()
                                    .fetch()
                                    .headers()
                                    .get(Session.SESSION_ID)
                                    .get(0)
                    )
            );
        return cachedSession.isEmpty() ?
                new Session() :
                cachedSession.get(0);
    }

    private Response baseReponse(Serializable serializable) throws IOException {
        return new JdkRequest(uri)
                .method(Request.POST)
                .header("Content-Type", "application/json")
                .through(BasicAuthWire.class)
                .through(SessionWire.class, session())
                .through(Retry409Wire.class)
                .through(RetryWire.class)
                .body()
                .set(GSON.toJson(serializable))
                .back()
                .fetch();
    }

    @Override
    public String post(Serializable serializable) throws IOException {
        return baseReponse(serializable).body();
    }

    @Override
    public <T> T post(Serializable serializable, Class<T> type) throws IOException {
        return baseReponse(serializable)
                .as(GsonResponse.class)
                .json(type);
    }
}
