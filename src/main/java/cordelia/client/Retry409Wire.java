package cordelia.client;

import com.jcabi.http.Request;
import com.jcabi.http.Response;
import com.jcabi.http.Wire;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.Map;

public final class Retry409Wire implements Wire {

    private final Wire origin;

    public Retry409Wire(Wire wire) {
        this.origin = wire;
    }

    @Override
    public Response send(Request req,
                         String home,
                         String method,
                         Collection<Map.Entry<String, String>> headers,
                         InputStream content,
                         int connect,
                         int read) throws IOException {
        Response response = this.origin.send(req, home, method, headers, content, connect, read);
        if (response.status() == HttpURLConnection.HTTP_CONFLICT)
            throw new IOException("no session");
        else
            return response;
    }
}
