package exercise;

import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter((user) -> user.get("gender").equals("male"))
                .sorted((user2, user1) -> {
                    LocalDate user2Birthday = LocalDate.parse(user2.get("birthday"));
                    LocalDate user1Birthday = LocalDate.parse(user1.get("birthday"));
                    return user2Birthday.compareTo(user1Birthday);
                })
                .map((user) -> user.get("name"))
                .collect(Collectors.toList());
    }
}
// END
