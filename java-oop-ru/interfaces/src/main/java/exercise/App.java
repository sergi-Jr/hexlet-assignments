package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> aparts, int resultElemsCount) {
        return aparts.stream()
                     .sorted(Home::compareTo)
                     .limit(resultElemsCount)
                     .map(h -> h.toString())
                     .collect(Collectors.toList());
    }
}
// END
