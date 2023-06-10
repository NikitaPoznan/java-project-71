package hexlet.code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> allKey = new TreeSet<>();
        allKey.addAll(file1.keySet());
        allKey.addAll(file2.keySet());

        for (String key : allKey) {
            Map<String, Object> keyDiff = new HashMap<>();
            keyDiff.put("Field", key);

            if (!file2.containsKey(key)) {
                keyDiff.put("Status", "Removed");
                keyDiff.put("OldValue", file1.get(key));
            } else if (!file1.containsKey(key)) {
                keyDiff.put("Status", "Added");
                keyDiff.put("NewValue", file2.get(key));

            } else if (Objects.equals(file1.get(key), file2.get(key))) {
                keyDiff.put("Status", "Same");
                keyDiff.put("OldValue", file1.get(key));
            } else {
                keyDiff.put("Status", "Update");
                keyDiff.put("NewValue", file2.get(key));
                keyDiff.put("OldValue", file1.get(key));
            }
            result.add(keyDiff);
        }

        return result;
    }
}



