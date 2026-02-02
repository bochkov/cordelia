package cordelia.jsonrpc.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.jsonrpc.RpcResponse;
import cordelia.jsonrpc.req.RqPortTest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class RsPortTest extends RpcResponse {

    @JsonProperty
    private Result result;

    @Getter
    @Setter
    @ToString
    public static final class Result {

        @JsonProperty("port_is_open")
        private Boolean portIsOpen;

        @JsonProperty("ip_protocol")
        private RqPortTest.IpProtocol ipProtocol;

    }

}
