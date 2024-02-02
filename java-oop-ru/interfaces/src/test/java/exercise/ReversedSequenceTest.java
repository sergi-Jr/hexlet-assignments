package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversedSequenceTest {
    private static String expected = "fedcba";
    private static ReversedSequence actual = new ReversedSequence("abcdef");

    @Test
    public void cctorTest() {
        Assertions.assertEquals(expected, actual.getSequence());
    }

    @Test
    public void lengthTest() {
        Assertions.assertEquals(expected.length(), actual.length());
    }

    @Test
    public void charAtTest() {
        Assertions.assertEquals('a', actual.charAt(5));
    }
}
