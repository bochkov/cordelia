package cordelia.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class NotNullToString {

    public static String eval(Object obj) {
        List<String> values = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                Object val = f.get(obj);
                if (val != null) {
                    JsonProperty ann = f.getAnnotation(JsonProperty.class);
                    String name = ann == null || ann.value().isEmpty()
                            ? f.getName()
                            : ann.value();
                    values.add(String.format("%s=%s", name, val));
                }
            } catch (ReflectiveOperationException ex) {
                //
            }
        }
        return obj.getClass().getSimpleName() + "(" + String.join(", ", values) + ")";
    }
}
