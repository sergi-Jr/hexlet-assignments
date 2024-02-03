package exercise;

import java.util.Map;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage dataBase) {
        Map<String, String> mappedDb = dataBase.toMap();
        mappedDb.forEach((k, v) -> {
            dataBase.set(v, k);
            dataBase.unset(k);
        });
    }
}
// END
