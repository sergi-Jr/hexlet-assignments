package exercise;

// BEGIN
public final class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double paramArea, double paramBalconyArea, int paramFloor) {
        area = paramArea;
        balconyArea = paramBalconyArea;
        floor = paramFloor;
    }

    @Override
    public Double getArea() {
        return area + balconyArea;
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
}
// END
