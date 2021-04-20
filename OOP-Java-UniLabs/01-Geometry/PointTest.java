import org.junit.*;

public class PointTest {

    @Test
    public void testGetX() {
        Point pt = new Point(1.0, 1.0);
        Point newPt = new Point(pt);
        Assert.assertEquals(1.0, newPt.getX(), 0.001);
    }

    @Test
    public void testGetY() {
        Point pt = new Point(1.0, 1.0);
        Point newPt = new Point(pt);
        Assert.assertEquals(1.0, newPt.getY(), 0.001);
    }

    @Test
    public void testDistanceSamepoint() {
        Point pt = new Point(1.0, 1.0);
        double distance = pt.distance(pt);
        Assert.assertEquals(0.0, distance, 0.001);
    }

    @Test
    public void testDistanceOtherPoint() {
        Point pt1 = new Point(1.0, 1.0);
        Point pt2 = new Point(1.0, 2.0);
        double distance = pt1.distance(pt2);
        Assert.assertEquals(1.0, distance, 0.001);
    }

    @Test
    public void testShift() {
        Point pt1 = new Point(1.0, 1.0);
        Point pt2 = new Point(2.0, 2.0);
        pt1.shift(1.0, 1.0);
        Assert.assertEquals(pt2.getX(), pt1.getX(), 0.001);
        Assert.assertEquals(pt2.getY(), pt1.getY(), 0.001);
    }
}