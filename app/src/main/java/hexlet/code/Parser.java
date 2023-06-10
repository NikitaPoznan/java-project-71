package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // еще в одном
        Map<String, Object> result = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
        return result;
    }

    public static Map<String, Object> parseYML(String content) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper();

        Map<String, Object> result = mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
        return result;
    }

    public static Map<String, Object> parse(String content, String extension) throws JsonProcessingException {
        return switch (extension) {
            case "json" -> parseJson(content);
            case "yml", "yaml" -> parseYML(content);
            default -> throw new RuntimeException();
        };
    }
}
