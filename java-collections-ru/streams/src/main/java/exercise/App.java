package exercise;

import java.util.List;

// BEGIN
public class App {
    private final static String[] FREE_EMAILS = new String[] {"@yandex.ru", "@hotmail.com", "@gmail.com"};
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter((e) -> isFreeEmail(e))
                .count();
    }

    private static boolean isFreeEmail(String email) {
        for (String freeEmail : FREE_EMAILS) {
            if (email.contains(freeEmail)) {
                return true;
            }
        }
        return false;
    }
}
// END
