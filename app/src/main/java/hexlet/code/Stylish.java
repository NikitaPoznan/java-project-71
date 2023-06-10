package hexlet.code;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> result) {
        StringBuilder stringResult = new StringBuilder("{\n");
        for (Map<String, Object> diff : result) {
            switch (diff.get("Status").toString()) {
                case ("Removed") -> stringResult.append("  - ").append(diff.get("Field")).append(": ")
                        .append(diff.get("OldValue")).append("\n");
                case ("Added") -> stringResult.append("  + ").append(diff.get("Field")).append(": ")
                        .append(diff.get("NewValue")).append("\n");
                case ("Update") -> {
                    stringResult.append("  - ").append(diff.get("Field"))
                            .append(": ").append(diff.get("OldValue")).append("\n");
                    stringResult.append("  + ").append(diff.get("Field"))
                            .append(": ").append(diff.get("NewValue")).append("\n");
                }
                case ("Same") -> stringResult.append("    ").append(diff.get("Field")).append(": ")
                        .append(diff.get("OldValue")).append("\n");
                default -> throw new RuntimeException("unknown status: " + diff.get("Status"));
            }


        }

        return stringResult.append("}").toString();
    }
}
