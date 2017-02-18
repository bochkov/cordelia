package cordelia.client;

import com.jcabi.http.ImmutableHeader;

public final class Session {

    public static final String SESSION = "X-Transmission-Session-Id";

    private final String id;

    public Session() {
        this.id = "";
    }

    public Session(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public ImmutableHeader header() {
        return new ImmutableHeader(SESSION, id);
    }
}