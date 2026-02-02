package cordelia.jsonrpc.req.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public final class Units {

    /**
     * 4 strings: KB/s, MB/s, GB/s, TB/s
     */
    @JsonProperty("speed_units")
    private List<String> speedUnits;

    /**
     * number of bytes in a KB (1000 for kB; 1024 for KiB)
     */
    @JsonProperty("speed_bytes")
    private Integer speedBytes;

    /**
     * 4 strings: KB/s, MB/s, GB/s, TB/s
     */
    @JsonProperty("size_units")
    private List<String> sizeUnits;

    /**
     * number of bytes in a KB (1000 for kB; 1024 for KiB)
     */
    @JsonProperty("size_bytes")
    private Integer sizeBytes;

    /**
     * 4 strings: KB/s, MB/s, GB/s, TB/s
     */
    @JsonProperty("memory_units")
    private List<String> memoryUnits;

    /**
     * number of bytes in a KB (1000 for kB; 1024 for KiB)
     */
    @JsonProperty("memory_bytes")
    private Integer memoryBytes;

}
