package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> result) {
        StringBuilder stringResult = new StringBuilder();

        for (Map<String, Object> diff : result) {
            switch (diff.get("Status").toString()) {
                case ("Removed") ->
                        stringResult.append("Property '").append(diff.get("Field")).append("' was removed\n");
                case ("Added") ->
                        stringResult.append("Property '").append(diff.get("Field")).append("' was added with value: ")
                                .append(formatValue(diff.get("NewValue"))).append("\n");
                case ("Update") ->
                        stringResult.append("Property '").append(diff.get("Field")).append("' was updated. From ")
                                .append(formatValue(diff.get("OldValue"))).append(" to ")
                                .append(formatValue(diff.get("NewValue"))).append("\n");
                case ("Same") -> {
                }
                default -> throw new RuntimeException("unknown status: " + diff.get("Status"));


            }
        }
        return stringResult.toString().strip();
    }

    public static String formatValue(Object object) {
        if (object == null) {
            return "null";
        }
        if (object instanceof ArrayList || object instanceof LinkedHashMap) {
            return "[complex value]";
        }

        if (object instanceof String) {
            return "'" + object + "'";
        }
        return object.toString();
    }
}
