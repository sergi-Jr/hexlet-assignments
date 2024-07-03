package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] arr) {
        Map<String, Integer> result = new HashMap<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        MinThread minThread = new MinThread(arr);
        MaxThread maxThread = new MaxThread(arr);
        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");
        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");
        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished");
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");
        result.put("min", minThread.getMin());
        result.put("max", maxThread.getMax());
        return result;
    }
    // END
}
