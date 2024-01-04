package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> originalMap,
                                              Map<String, Object> diffMap) {
        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();
        TreeSet<Map.Entry<String, Object>> treeSetMapCrossed = new TreeSet<>(Map.Entry.comparingByKey());
        for (Map.Entry<String, Object> entry : originalMap.entrySet()) {
            treeSetMapCrossed.add(entry);
            resultMap.put(entry.getKey(), "deleted");
        }
        for (Map.Entry<String, Object> entry : diffMap.entrySet()) {
            if (treeSetMapCrossed.contains(entry)) {
                Map.Entry<String, Object> setElement = treeSetMapCrossed.ceiling(entry);
                if (setElement.getValue().equals(entry.getValue())) {
                    resultMap.put(entry.getKey(), "unchanged");
                } else {
                    resultMap.put(entry.getKey(), "changed");
                }
            } else {
                resultMap.put(entry.getKey(), "added");
            }
        }
        return resultMap;
    }
}
//END
