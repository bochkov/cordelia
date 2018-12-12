package cordelia.rpc;

import java.util.Map;

public interface OptReq extends Req {

    Map<String, Object> arguments();

}
