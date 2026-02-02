package cordelia.jsonrpc.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BKey {

    /**
     * true if session upload limits are honored
     */
    public static final String HONORS_SESSION_LIMITS = "honors_session_limits";

    /**
     * Bandwidth group name
     */
    public static final String NAME = "name";

    /**
     * max global download speed (kB/s)
     */
    public static final String SPEED_LIMIT_DOWN = "speed_limit_down";

    /**
     * true means enabled
     */
    public static final String SPEED_LIMIT_DOWN_ENABLED = "speed_limit_down_enabled";

    /**
     * max global upload speed (kB/s)
     */
    public static final String SPEED_LIMIT_UP = "speed_limit_up";

    /**
     * true means enabled
     */
    public static final String SPEED_LIMIT_UP_ENABLED = "speed_limit_up_enabled";

}
