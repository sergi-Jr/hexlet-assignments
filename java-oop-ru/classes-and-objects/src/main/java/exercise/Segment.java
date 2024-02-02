package exercise;

// BEGIN
public final class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point paramBeginPoint, Point paramEndPoint) {
        beginPoint = paramBeginPoint;
        endPoint = paramEndPoint;

    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int midPointX = (beginPoint.getX() + endPoint.getX()) / 2;
        int midPointY = (beginPoint.getY() + endPoint.getY()) / 2;
        Point midPoint = new Point(midPointX, midPointY);
        return midPoint;
    }
}
// END
