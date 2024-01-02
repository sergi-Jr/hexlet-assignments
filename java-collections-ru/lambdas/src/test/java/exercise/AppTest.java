package exercise;

import org.junit.jupiter.api.Test;

// BEGIN
public class AppTest {
    @Test
    public void enlargeCorrect2DArrSuccessReturned() {
        String[][] arr = {
                {"*", "*", "*", "*"},
                {"*", " ", " " ,"*"},
                {"*",  " ",  " ", "*"},
                {"*", "*", "*", "*"}
        };
        String[][] expectedArr = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };
        String[][] actualArr = App.enlargeArrayImage(arr);
        for (int i = 0; i < expectedArr.length; i++) {
            for (int j = 0; j < expectedArr[i].length; j++) {
                assert expectedArr[i][j].equals(actualArr[i][j]) : "Not works with" + i + " " + j;
            }
        }
    }
}
// END
