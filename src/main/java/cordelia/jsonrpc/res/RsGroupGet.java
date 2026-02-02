package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import cordelia.jsonrpc.types.BKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class RsGroupGet extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {
        /**
         * true if session upload limits are honored
         */
        @JsonProperty(BKey.HONORS_SESSION_LIMITS)
        private Boolean honorsSessionLimits;

        /**
         * Bandwidth group name
         */
        @JsonProperty(BKey.NAME)
        private String name;

        /**
         * max global download speed (kB/s)
         */
        @JsonProperty(BKey.SPEED_LIMIT_DOWN)
        private Long speedLimitDown;

        /**
         * true means enabled
         */
        @JsonProperty(BKey.SPEED_LIMIT_DOWN_ENABLED)
        private Boolean speedLimitDownEnabled;

        /**
         * max global upload speed (kB/s)
         */
        @JsonProperty(BKey.SPEED_LIMIT_UP)
        private Long speedLimitUp;

        /**
         * true means enabled
         */
        @JsonProperty(BKey.SPEED_LIMIT_UP_ENABLED)
        private Boolean speedLimitUpEnabled;
    }
}
