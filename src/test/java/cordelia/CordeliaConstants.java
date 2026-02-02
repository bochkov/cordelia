package cordelia;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CordeliaConstants {

    public static final String RPC_URL = System.getenv("TRANSMISSION_RPC");
    public static final long TAG = 122222L;

}
