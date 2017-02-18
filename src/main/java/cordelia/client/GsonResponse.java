package cordelia.client;

import com.google.gson.Gson;
import com.jcabi.http.Request;
import com.jcabi.http.Response;

import java.util.List;
import java.util.Map;

public final class GsonResponse implements Response {

    private final Response origin;

    public GsonResponse(Response response) {
        this.origin = response;
    }

    @Override
    public Request back() {
        return origin.back();
    }

    @Override
    public int status() {
        return origin.status();
    }

    @Override
    public String reason() {
        return origin.reason();
    }

    @Override
    public Map<String, List<String>> headers() {
        return origin.headers();
    }

    @Override
    public String body() {
        return origin.body();
    }

    @Override
    public byte[] binary() {
        return origin.binary();
    }

    @Override
    public <T extends Response> T as(Class<T> type) {
        return origin.as(type);
    }

    public <T> T json(Class<T> type) {
        return new Gson().fromJson(body(), type);
    }
}
