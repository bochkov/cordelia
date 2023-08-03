package cordelia.rpc.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class Group {

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
