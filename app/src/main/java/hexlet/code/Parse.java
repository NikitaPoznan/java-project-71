package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public class Parse {
    public static Map<String,Object> parseJson(String content) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> result = mapper.readvalue(content, new TypeReference <Map<String,Object>>(){});
        return result;
    }
}
