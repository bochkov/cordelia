package cordelia.rpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class RsFreeSpace implements RsArguments {

    private String path;

    @JsonProperty("size-bytes")
    private Long sizeBytes;

    @JsonProperty("total_size")
    private Long totalSize;

}
