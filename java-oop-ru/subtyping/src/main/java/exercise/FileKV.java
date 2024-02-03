package exercise;

import java.util.Map;

// BEGIN
public final class FileKV implements KeyValueStorage {
    private String filepath;

    public FileKV(String path, Map<String, String> data) {
        filepath = path;
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> updatedDb = Utils.unserialize(Utils.readFile(filepath));
        updatedDb.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(updatedDb));
    }

    @Override
    public void unset(String key) {
        Map<String, String> updatedDb = Utils.unserialize(Utils.readFile(filepath));
        updatedDb.remove(key);
        Utils.writeFile(filepath, Utils.serialize(updatedDb));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> updatedDb = Utils.unserialize(Utils.readFile(filepath));
        return updatedDb.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(filepath));
    }
}
// END
