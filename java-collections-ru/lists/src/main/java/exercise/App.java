package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String scrabble, String word) {
        word = word.toLowerCase();
        List<Character> letters = getCharsCollectionFromString(scrabble);
        List<Character> wordLetters = getCharsCollectionFromString(word);
        for (Character ch : letters) {
            wordLetters.remove(ch);
            if (wordLetters.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    private static List<Character> getCharsCollectionFromString(String str) {
        List<Character> result = new ArrayList<>();
        char[] chArr = str.toCharArray();
        for (char ch : chArr) {
            result.add(ch);
        }
        return result;
    }
}
//END
