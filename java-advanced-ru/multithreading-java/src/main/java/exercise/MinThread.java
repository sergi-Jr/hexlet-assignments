package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private int[] arr;

    private int min;

    public MinThread(int[] array) {
        arr = array;
    }

    @Override
    public void run() {
        min = Arrays.stream(arr).min().getAsInt();
    }

    public int getMin() {
        return min;
    }
}
// END
