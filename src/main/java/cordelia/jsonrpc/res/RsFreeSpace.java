package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class RsFreeSpace extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {

        /**
         * same as the Request parameter
         */
        @JsonProperty
        private String path;

        /**
         * the size, in bytes, of the free space in that directory
         */
        @JsonProperty("size_bytes")
        private Long sizeBytes;

        /**
         * the total capacity, in bytes, of that directory
         */
        @JsonProperty("total_size")
        private Long totalSize;
    }
}
