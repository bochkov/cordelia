package cordelia.client;

import java.io.IOException;
import java.io.Serializable;

public interface Client {

    String post(Serializable serializable) throws IOException;

    <T> T post(Serializable serializable, Class<T> clz) throws IOException;
}
