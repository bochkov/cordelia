package cordelia.util;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

import java.util.Base64;

public final class Base64Deserialize extends ValueDeserializer<byte[]> {
    @Override
    public byte[] deserialize(JsonParser p, DeserializationContext cxt) throws JacksonException {
        String val = p.getValueAsString();
        return Base64.getDecoder().decode(val);
    }
}
