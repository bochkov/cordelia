package cordelia.client;

import com.jcabi.http.Request;
import com.jcabi.http.Response;
import com.jcabi.http.Wire;
import com.jcabi.log.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public final class SessionWire implements Wire {

    private final transient Wire origin;
    private final Session session;

    public SessionWire(Wire wire, Session session) {
        this.origin = wire;
        this.session = session;
    }

    @Override
    public Response send(Request req,
                         String home,
                         String method,
                         Collection<Map.Entry<String, String>> headers,
                         InputStream content,
                         int connect,
                         int read) throws IOException {
        if (session == null)
            throw new IOException("no session");
        final Collection<Map.Entry<String, String>> hdrs = new LinkedList<>();
        for (final Map.Entry<String, String> header : headers)
            hdrs.add(header);
        hdrs.add(session.header());
        Logger.debug(this, "Using sessionId : %s", session.id());
        return this.origin.send(req, home, method, hdrs, content, connect, read);
    }
}