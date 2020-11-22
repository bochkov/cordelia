package cordelia.client;

import java.io.Serializable;

public interface Client {

    <T> T post(Serializable serializable, Class<T> clz);
}
