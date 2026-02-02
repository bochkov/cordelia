package cordelia.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.RpcResponse;
import kong.unirest.core.ObjectMapper;
import kong.unirest.core.Unirest;
import kong.unirest.modules.jackson.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.StreamWriteFeature;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.json.JsonMapper;

import java.nio.charset.StandardCharsets;

@Slf4j
public final class TrClient {

    private final String url;
    private final SessionStore sessionStore = new SessionStore();

    public TrClient(String url) {
        this(url, null, null);
    }

    public TrClient(String url, String user, String password) {
        this.url = url;
        JsonMapper om = JsonMapper.builder()
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .enable(StreamWriteFeature.IGNORE_UNKNOWN)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .changeDefaultPropertyInclusion(pi -> pi
                        .withContentInclusion(JsonInclude.Include.NON_EMPTY)
                        .withValueInclusion(JsonInclude.Include.NON_NULL)
                )
                .build();
        Unirest.config()
                .setDefaultResponseEncoding(StandardCharsets.UTF_8.name())
                .setDefaultHeader("Content-Type", "application/json")
                .setObjectMapper(new JacksonObjectMapper(om));
        if (user != null && password != null) {
            Unirest.config()
                    .setDefaultBasicAuth(user, password);
        }
    }

    public <S extends RpcResponse> S execute(RpcRequest<S> req) {
        return Unirest.post(url)
                .header(Session.SESSION_ID, session().getId())
                .body(req)
                .asObject(req.responseClass())
                .ifSuccess(c ->
                        c.getParsingError().ifPresent(e ->
                                LOG.debug("body: {}", e.getOriginalBody()))
                )
                .ifFailure(c -> {
                    LOG.warn("status = {}", c.getStatus());
                    c.getParsingError().ifPresent(e -> {
                        LOG.warn("body: {}", e.getOriginalBody());
                        LOG.warn(e.getMessage(), e);
                    });
                })
                .getBody();
    }

    private Session session() {
        if (sessionStore.isEmpty()) {
            String sessionId = Unirest.post(url)
                    .asEmpty()
                    .getHeaders()
                    .getFirst(Session.SESSION_ID);
            sessionStore.set(new Session(sessionId));
            LOG.debug("session-id = {}", sessionId);
        }
        return sessionStore.get();
    }

    public ObjectMapper om() {
        return Unirest.config().getObjectMapper();
    }

    public void shutdown() {
        Unirest.shutDown();
    }
}
