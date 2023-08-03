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
public final class RsPortCheck implements RsArguments {

    @JsonProperty("port-is-open")
    private Boolean portIsOpen;

}
