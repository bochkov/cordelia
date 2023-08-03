package cordelia.rpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@ReqMethod("group-set")
@Builder
public final class RqGroupSet implements RqArguments {

    private Boolean honorsSessionLimits;
    private String name;
    @JsonProperty("speed-limit-down-enabled")
    private Boolean speedLimitDownEnabled;
    @JsonProperty("speed-limit-down")
    private Long speedLimitDown;
    @JsonProperty("speed-limit-up-enabled")
    private Boolean speedLimitUpEnabled;
    @JsonProperty("speed-limit-up")
    private Long speedLimitUp;

}
