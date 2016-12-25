package cordelia;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import cordelia.rpc.Request;
import cordelia.rpc.Response;
import cordelia.rpc.method.SessionGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public final class TransmissionClient {

    public static final String SESSION_HEADER = "X-Transmission-Session-Id";

    private static final Logger LOG = LoggerFactory.getLogger(TransmissionClient.class);

    private final GenericUrl url;
    private final HttpRequestFactory requestFactory;
    private final JsonFactory jsonFactory;

    private String sessionId = "";

    public TransmissionClient(String url) {
        this(url, "", "");
    }

    public TransmissionClient(String url, String user, String password) {
        this.url = new GenericUrl(url);
        this.jsonFactory = new GsonFactory();
        this.requestFactory = new NetHttpTransport().createRequestFactory(request -> {
            request.getHeaders()
                    .setBasicAuthentication(user, password)
                    .set(SESSION_HEADER, sessionId);
        });
        try {
            requestFactory
                    .buildPostRequest(this.url, new JsonHttpContent(jsonFactory, new SessionGet()))
                    .setUnsuccessfulResponseHandler((request, response, supportsRetry) -> {
                        sessionId = response.getHeaders().getFirstHeaderStringValue(SESSION_HEADER);
                        return supportsRetry;
                    })
                    .execute();
            LOG.info("Set new SessionId=" + sessionId);
        }
        catch (IOException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
    }

    public Response execute(Request request) throws IOException {
        HttpResponse res = requestFactory
                .buildPostRequest(url, new JsonHttpContent(jsonFactory, request))
                .execute();
        return jsonFactory.fromInputStream(res.getContent(), Response.class);
    }
}
