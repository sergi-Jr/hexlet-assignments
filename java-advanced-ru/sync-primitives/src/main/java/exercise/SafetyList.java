package exercise;

import java.util.Arrays;

class SafetyList {
    private int[] arr;

    public SafetyList() {
        arr = new int[0];
    }

    // BEGIN
    public synchronized void add(int num) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = num;
    }

    public int get(int index) {
        return arr[index];
    }

    public int getSize() {
        return arr.length;
    }
    // END
}
