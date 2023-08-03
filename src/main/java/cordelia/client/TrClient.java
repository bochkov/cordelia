package cordelia.client;

import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import cordelia.rpc.RqArguments;
import cordelia.rpc.RsArguments;
import kong.unirest.core.Unirest;
import kong.unirest.jackson.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class TrClient {

    private final String url;
    private final SessionStore sessionStore = new SessionStore();
    private final ObjectMapper om = JsonMapper.builder()
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .enable(JsonGenerator.Feature.IGNORE_UNKNOWN)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .addModule(new JavaTimeModule())
            .build();

    public TrClient(String url) {
        this(url, null, null);
    }

    public TrClient(String url, String user, String password) {
        this.url = url;
        Unirest.config()
                .setDefaultResponseEncoding(StandardCharsets.UTF_8.name())
                .setDefaultHeader("Content-Type", "application/json")
                .setObjectMapper(new JacksonObjectMapper(om));
        if (user != null && password != null) {
            Unirest.config()
                    .setDefaultBasicAuth(user, password);
        }
    }

    public <E extends RqArguments, S extends RsArguments> TypedResponse<S> execute(E req) {
        return execute(req, null);
    }

    public <E extends RqArguments, S extends RsArguments> TypedResponse<S> execute(E req, Long tag) {
        LOG.debug("using session-id={}", session().id());
        return Unirest.post(url)
                .header(Session.SESSION_ID, session().id())
                .body(req.toReq(tag))
                .asObject(RawResponse.class)
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
                .map(raw -> new TypedResponse<S>(
                                raw.getTag(),
                                raw.getResult(),
                                om.convertValue(raw.getArguments(), req.answerClass())
                        )
                )
                .getBody();
    }

    public void shutdown() {
        Unirest.shutDown();
    }

    private Session session() {
        if (sessionStore.isEmpty()) {
            String sessionId = Unirest.post(url)
                    .asEmpty()
                    .getHeaders()
                    .getFirst(Session.SESSION_ID);
            sessionStore.set(new Session(sessionId));
        }
        return sessionStore.get();
    }
}
