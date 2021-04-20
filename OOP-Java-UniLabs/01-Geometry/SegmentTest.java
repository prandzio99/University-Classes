import org.junit.*;

public class SegmentTest {

    @Test
    public void testShift() {
        Segment seg = new Segment(1.0, 1.0, 2.0, 2.0);
        seg.shift(1.0, 1.0);
        Assert.assertEquals(2.0, seg.getaX(), 0.001);
        Assert.assertEquals(3.0, seg.getaY(), 0.001);
        Assert.assertEquals(2.0, seg.getbX(), 0.001);
        Assert.assertEquals(3.0, seg.getbY(), 0.001);
    }

    @Test
    public void testPointDistance() {
        Segment seg = new Segment(2.0, 3.0, 4.0, 5.0);
        Point pt = new Point(0, 0);
        double distance = seg.pointDinstance(pt);
        Assert.assertEquals(0.5, distance, 0.001 );
    }

    @Test
    public void getLength() {
        Segment seg = new Segment(0, 0, 1, 1);
        double length = seg.length();
        Assert.assertEquals(Math.sqrt(2), length, 0.001);
    }
}