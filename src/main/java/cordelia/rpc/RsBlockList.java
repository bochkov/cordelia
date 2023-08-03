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
public final class RsBlockList implements RsArguments {

    @JsonProperty("blocklist-size")
    private Integer blockListSize;

}
