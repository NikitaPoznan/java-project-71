package hexlet.code;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String convertor (List<Map<String,Object>> result){
        StringBuilder stringResult = new StringBuilder("{"); // ?
        for(Map<String, Object> key : result){
            switch (key.get("Status").toString()) {
                case ("Removed") -> stringResult.append("-", key)
                case ("ADDED") -> stringResult.append("+", key)
                case ("UPDATE") -> stringResult.append()

            }
        }
        return stringResult;
    }
}
