package cordelia.rpc.types;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status {

    STOPPED(0),
    QUEUED_TO_VERIFY(1),
    VERIFYING(2),
    QUEUED_TO_DOWNLOAD(3),
    DOWNLOADING(4),
    QUEUED_TO_SEED(5),
    SEEDING(6);

    private final int idx;

    @JsonValue
    public int toValue() {
        return idx;
    }

}
