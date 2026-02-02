package cordelia.util;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CookieSerializer extends ValueSerializer<Map<String, String>> {
    @Override
    public void serialize(Map<String, String> value, JsonGenerator gen, SerializationContext ctx) throws JacksonException {
        List<String> vals = new ArrayList<>();
        for (Map.Entry<String, String> entry : value.entrySet()) {
            vals.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
        gen.writeString(String.join(";", vals));
    }
}
