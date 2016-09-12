package cordelia;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import cordelia.rpc.Request;
import cordelia.rpc.Response;
import cordelia.rpc.method.SessionGet;
import cordelia.rpc.method.SessionStats;
import cordelia.rpc.method.TorrentGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

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
            request.getHeaders().setBasicAuthentication(user, password);
            request.getHeaders().set(SESSION_HEADER, sessionId);
        });

        fetchHeaders();
        // enableLogging();
    }

    private void enableLogging() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HttpTransport.class.getName());
        logger.setLevel(Level.FINE);
        logger.addHandler(new Handler() {
            @Override
            public void publish(LogRecord record) {
                LOG.info(record.getMessage(), record.getThrown());
            }

            @Override
            public void flush() {}

            @Override
            public void close() throws SecurityException {}
        });
    }

    private void fetchHeaders() {
        try {
            HttpRequest req = requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, new SessionGet()));
            req.setUnsuccessfulResponseHandler((request, response, supportsRetry) -> {
                sessionId = response.getHeaders().getFirstHeaderStringValue(SESSION_HEADER);
                return false;
            });
            req.execute();
        }
        catch (IOException ex) {
            LOG.info("Set new SessionId=" + sessionId);
        }
    }

    public Response execute(Request request) {
        try {
            HttpRequest req = requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, request));
            HttpResponse res = req.execute();
            return jsonFactory.fromInputStream(res.getContent(), Response.class);
        }
        catch (IOException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
        return new Response();
    }

    public static void main(String[] args) {
        TransmissionClient cl = new TransmissionClient("http://192.168.55.5:9091/transmission/rpc");
        LOG.info(cl.execute(new TorrentGet(Arrays.asList("addedDate", "eta"))).toString());
    }
}
