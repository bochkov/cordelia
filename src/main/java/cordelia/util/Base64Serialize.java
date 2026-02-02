package cordelia.util;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.util.Base64;

public final class Base64Serialize extends ValueSerializer<byte[]> {
    @Override
    public void serialize(byte[] value, JsonGenerator gen, SerializationContext ctx) throws JacksonException {
        gen.writeString(
                Base64.getEncoder().encodeToString(value)
        );
    }
}
