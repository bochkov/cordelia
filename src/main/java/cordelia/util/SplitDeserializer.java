package cordelia.util;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SplitDeserializer extends ValueDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctx) throws JacksonException {
        String val = p.getValueAsString();
        if (val == null || val.isEmpty()) {
            return null;
        }

        String[] arr = val.split("\r?\n+");
        List<String> res = new ArrayList<>();
        Collections.addAll(res, arr);
        return Collections.unmodifiableList(res);
    }
}
