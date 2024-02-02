package exercise;

// BEGIN
public interface Home {
    Double getArea();

    default int compareTo(Home house) {
        double epsilon = 0.00001d;
        Double subtraction = getArea() - house.getArea();
        if (Math.abs(subtraction)  < epsilon) {
            return 0;
        }
        return subtraction > 0d ? 1 : -1;
    }
}
// END
