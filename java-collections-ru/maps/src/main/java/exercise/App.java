package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> result = new HashMap<>();
        if (sentence.isEmpty()) {
            return result;
        }
        String[] splitSentence = sentence.split("\\s+");
        for (String word : splitSentence) {
            Integer value = result.get(word);
            if (value != null) {
                result.put(word, value + 1);
                continue;
            }
            result.put(word, 1);
        }
        return result;
    }
    public static String toString(Map<String, Integer> wordsCount) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        wordsCount.forEach((key, value) -> {
            builder.append("\n  " + key + ": " + value);
        });
        builder.append(wordsCount.isEmpty() ? "}" : "\n}");
        return builder.toString();
    }
}
//END
