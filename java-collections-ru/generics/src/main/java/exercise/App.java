package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books,
                                                      Map<String, String> concreteBooksData) {
        return books.stream()
                .filter((b) -> isSuitableBook(b, concreteBooksData))
                .collect(Collectors.toList());
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
