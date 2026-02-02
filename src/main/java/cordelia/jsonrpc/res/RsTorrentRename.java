package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class RsTorrentRename extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String name;

        @JsonProperty
        private String path;

    }

}
