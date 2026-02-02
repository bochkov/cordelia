package cordelia.util;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.util.List;

public final class SplitSerializer extends ValueSerializer<List<String>> {
    @Override
    public void serialize(List<String> value, JsonGenerator gen, SerializationContext ctx) throws JacksonException {
        gen.writeString(
                String.join("\n", value)
        );
    }
}
