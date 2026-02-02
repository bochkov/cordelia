package cordelia.jsonrpc.req.types;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SchedDay {

    SUNDAY(1 << 0),
    MONDAY(1 << 1),
    TUESDAY(1 << 2),
    WEDNESDAY(1 << 3),
    THURSDAY(1 << 4),
    FRIDAY(1 << 5),
    SATURDAY(1 << 6),
    WEEKDAY(MONDAY.val | TUESDAY.val | WEDNESDAY.val | THURSDAY.val | FRIDAY.val),
    WEEKEND(SUNDAY.val | SATURDAY.val),
    ALL(WEEKDAY.val | WEEKEND.val);

    @JsonValue
    private final int val;

}
