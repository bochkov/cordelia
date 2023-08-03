package cordelia.rpc;

import java.util.List;

import lombok.RequiredArgsConstructor;

@ReqMethod(value = "group-get", answer = RsGroupGet.class)
@RequiredArgsConstructor
public final class RqGroupGet implements RqArguments {

    private final List<String> group;

    public RqGroupGet() {
        this(null);
    }

}
