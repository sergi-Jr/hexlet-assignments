package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<Integer> expectedInListLength = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> actualInListLength = App.take(numbers, 2);

        assertThat(actualInListLength).isEqualTo(expectedInListLength);

        List<Integer> expectedOutListLength = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> actualOutListLength = App.take(numbers, 8);

        assertThat(actualOutListLength).isEqualTo(expectedOutListLength);

        List<Integer> expectedNegativeParamValue = new ArrayList<>();
        List<Integer> actualNegativeParamValue = App.take(numbers, -1);

        assertThat(actualNegativeParamValue).isEqualTo(expectedNegativeParamValue);

        List<Integer> expectedZeroParamValue = new ArrayList<>();
        List<Integer> actualZeroParamValue = App.take(numbers, 0);

        assertThat(actualZeroParamValue).isEqualTo(expectedZeroParamValue);
        // END
    }
}
