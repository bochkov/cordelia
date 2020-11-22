package cordelia.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class TrClient implements Client {

    private final String url;
    private final List<Session> cachedSession = new ArrayList<>();

    public TrClient(String url) {
        this.url = url;
    }

    private void obtainSession() {
        cachedSession.clear();
        String sessionId = Unirest.post(url)
                .header("Content-Type", "application/json")
                .asEmpty()
                .getHeaders()
                .getFirst(Session.SESSION_ID);
        cachedSession.add(new Session(sessionId));
    }

    private Session session() {
        if (cachedSession.isEmpty())
            obtainSession();
        return cachedSession.isEmpty() ?
                new Session() :
                cachedSession.get(0);
    }

    @Override
    public <T> T post(Serializable serializable, Class<T> type) {
        LOG.debug("using session-id={}", session().id());
        return Unirest.post(url)
                .header("Content-Type", "application/json")
                .header(Session.SESSION_ID, session().id())
                .body(serializable)
                .asObject(type)
                .ifSuccess(response -> {
                    LOG.debug("ok");
                    response.getParsingError().ifPresent(e -> LOG.debug("body: {}", e.getOriginalBody()));
                })
                .ifFailure(response -> {
                    LOG.warn("status={}", response.getStatus());
                    response.getParsingError().ifPresent(e -> {
                        LOG.warn("body: {}", e.getOriginalBody());
                        LOG.warn(e.getMessage(), e);
                    });
                })
                .getBody();
    }
}
