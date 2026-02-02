package cordelia.util;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public final class UnixTimestampDeserialize extends ValueDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctx) throws JacksonException {
        long val = p.getValueAsLong();
        return Instant.ofEpochSecond(val)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
