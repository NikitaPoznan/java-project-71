package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String BaseFormatter(List<Map<String, Object>> result, String format) throws JsonProcessingException {


        return switch (format) {
            case ("stylish") -> Stylish.format(result);
            case ("plain") -> Plain.format(result);
            case ("json") -> Json.format(result);
            default -> throw new RuntimeException("unknown format");
        };
    }
}
