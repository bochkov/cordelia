package cordelia.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Session {

    public static final String SESSION_ID = "X-Transmission-Session-Id";

    @Getter
    private final String id;

}
