package cordelia.rpc.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class Units {

    @JsonProperty("speed-units")
    private List<String> speedUnits;

    @JsonProperty("speed-bytes")
    private Integer speedBytes;

    @JsonProperty("size-units")
    private List<String> sizeUnits;

    @JsonProperty("size-bytes")
    private Integer sizeBytes;

    @JsonProperty("memory-units")
    private List<String> memoryUnits;

    @JsonProperty("memory-bytes")
    private Integer memoryBytes;

}
