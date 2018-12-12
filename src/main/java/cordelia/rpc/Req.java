package cordelia.rpc;

import java.io.Serializable;

public interface Req extends Serializable {

    String method();

    Integer tag();

}
