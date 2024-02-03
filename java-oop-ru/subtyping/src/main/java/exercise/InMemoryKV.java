package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public final class InMemoryKV implements KeyValueStorage {
    private Map<String, String> dataBase;

    public InMemoryKV(Map<String, String> data) {
        dataBase = new HashMap<>(data);
    }

    @Override
    public void set(String key, String value) {
        dataBase.put(key, value);
    }

    @Override
    public void unset(String key) {
        dataBase.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataBase.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dataBase);
    }
}
// END
