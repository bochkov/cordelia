package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class RsTorrentAdd extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {

        @JsonProperty("torrent_added")
        @JsonAlias("torrent_duplicate")
        private Info info;

        // TODO is duplicated field

    }

    @Getter
    @Setter
    @ToString
    public static final class Info {

        @JsonProperty
        private Long id;

        @JsonProperty("hash_string")
        private String hashString;

        @JsonProperty
        private String name;
    }


}
