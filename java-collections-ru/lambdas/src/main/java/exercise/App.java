package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        if (image.length == 0) {
            return new String[][]{};
        }
        String[][] enlargedImage = Arrays.stream(image)
                                        .map(line -> Arrays.stream(line)
                                                            .map(item -> List.of(item, item))
                                                            .flatMap(List::stream)
                                                            .toArray(String[]::new))
                                        .map(s -> List.of(s, s))
                                        .flatMap(List::stream)
                                        .toArray(String[][]::new);
        return enlargedImage;
    }
}
// END
