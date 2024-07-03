package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private int[] arr;

    private int max;

    public MaxThread(int[] array) {
        arr = array;
    }

    @Override
    public void run() {
        max = Arrays.stream(arr).max().getAsInt();
    }

    public int getMax() {
        return max;
    }
}
// END
