package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.req.types.Ids;
import cordelia.jsonrpc.res.RsTorrentGet;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

public final class RqTorrentGet extends RpcRequest<RsTorrentGet> {

    @JsonProperty
    private final Params params;

    public RqTorrentGet(Long id, Params params) {
        super("torrent_get", id);
        this.params = params;
    }

    @Builder
    public static final class Params {

        @JsonProperty
        private Ids ids;

        @JsonProperty
        private List<String> fields;

        @JsonProperty
        private Format format;

    }

    @RequiredArgsConstructor
    public enum Format {

        OBJECTS("objects"),
        TABLE("table");

        @JsonValue
        private final String format;

    }

}
