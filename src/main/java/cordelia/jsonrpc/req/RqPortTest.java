package cordelia.jsonrpc.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import cordelia.jsonrpc.RpcRequest;
import cordelia.jsonrpc.res.RsPortTest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

public final class RqPortTest extends RpcRequest<RsPortTest> {

    @JsonProperty
    private final Params params;

    public RqPortTest(Long id, Params params) {
        super("port_test", id);
        this.params = params;
    }

    @Builder
    public static final class Params {

        @JsonProperty("ip_protocol")
        private IpProtocol ipProtocol;

    }

    @RequiredArgsConstructor
    public enum IpProtocol {

        IPv4("ipv4"), IPv6("ipv6");

        @JsonValue
        private final String protocol;
    }
}
