package exercise;

// BEGIN
public final class Circle {
    private Point center;
    private int radius;

    public Circle(Point c, int r) {
        center = c;
        radius = r;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException();
        }
        return Math.PI * radius * radius;
    }
}
// END
