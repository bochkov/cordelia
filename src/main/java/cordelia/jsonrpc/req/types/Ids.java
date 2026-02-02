package cordelia.jsonrpc.req.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class Ids {

    @JsonProperty
    private final Object ids;

    public static Ids of(Integer id) {
        return new Ids(id);
    }

    public static Ids hash(String hash) {
        return new Ids(hash);
    }

    public static Ids any(List<Object> values) {
        return new Ids(values);
    }

    public static Ids recentlyActive() {
        return new Ids("recently_active");
    }

}
