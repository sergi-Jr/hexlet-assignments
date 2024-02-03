package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

class FileKVTest {

    private Map<String, String> testMap;
    private KeyValueStorage testStorage;
    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
        testMap =  Map.of("key", "value");
        testStorage = new FileKV(filepath.toString(), testMap);
    }

    // BEGIN
    @Test
    public void setTestSameKey() {
        testStorage.set("key", "newValue");
        var expected = Map.of("key", "newValue");
        Assertions.assertEquals(expected, testStorage.toMap());
    }

    @Test
    public void setTestAnotherKey() {
        testStorage.set("key1", "newValue");
        var expected = Map.of("key", "value", "key1", "newValue");
        Assertions.assertEquals(expected, testStorage.toMap());
    }

    @Test
    public void unsetTestHasKey() {
        testStorage.unset("key");
        var expected = Map.of();
        Assertions.assertEquals(expected, testStorage.toMap());
    }

    @Test
    public void unsetTestNoKey() {
        testStorage.unset("key1");
        var expected = Map.of("key", "value");
        Assertions.assertEquals(expected, testStorage.toMap());
    }

    @Test
    public void getTestHasKey() {
        var actual = testStorage.get("key", "default");
        var expected = "value";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTestDefaultReturned() {
        var actual = testStorage.get("key1", "default");
        var expected = "default";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toMapTest() {
        var actual = testStorage.toMap();
        var expected = testMap;
        Assertions.assertEquals(expected, actual);
    }
    // END
}
