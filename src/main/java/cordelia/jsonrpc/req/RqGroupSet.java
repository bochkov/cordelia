package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsEmpty;
import cordelia.jsonrpc.types.BKey;
import lombok.Builder;

public final class RqGroupSet extends RpcRequest<RsEmpty> {

    @JsonProperty
    private final Params params;

    public RqGroupSet(Long id, Params params) {
        super("group_set", id);
        this.params = params;
    }

    @Builder
    public static final class Params {

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
