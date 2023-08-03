package cordelia.client;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class RawResponse {

    private Long tag;
    private String result;
    private Map<String, Object> arguments;

}
