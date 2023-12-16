package exercise;

import java.util.*;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books,
                                                      Map<String, String> concreteBooksData) {
        List<Map<String, String>> result = new ArrayList<>();
        books.stream()
                .filter((b) -> isSuitableBook(b, concreteBooksData))
                .forEach((b) -> result.add(b));
        return result;
    }
    private static <T extends Map> boolean isSuitableBook(T book, T bookFilter) {
        for (Object filterData : bookFilter.values()) {
            if (!book.containsValue(filterData)) {
                return false;
            }
        }
        return true;
    }
}
//END
