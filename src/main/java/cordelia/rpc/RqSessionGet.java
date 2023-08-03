package cordelia.rpc;

import java.util.List;

import lombok.RequiredArgsConstructor;

@ReqMethod(value = "session-get", answer = RsSessionGet.class)
@RequiredArgsConstructor
public final class RqSessionGet implements RqArguments {

    private final List<String> fields;

    public RqSessionGet() {
        this(null);
    }
}
