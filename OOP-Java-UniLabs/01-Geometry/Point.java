// a class representing a point on a plane

public class Point {
    // parameters
    private double x;
    private double y;

    // object creators
    // creator with x and y arguments
    public Point(double x, double y) {
        setValues(x, y);
    }

    // creator with no arguments
    public Point() {
        setValues(0, 0);
    }

    // creator with another point as an argument
    public Point(Point pt) {
        setValues(pt.x, pt.y);
    }

    // a private method to set values of x and y
    private void setValues(double a, double b) {
        this.x = a;
        this.y = b;
    }

    // a method returning the value of parameter X
    public double getX() {
        return x;
    }

    // a method setting the value of parameter X
    public void setX(double x) {
        this.x = x;
    }

    // a method returning value of parameter Y
    public double getY() {
        return y;
    }

    // a method setting the value of parameter Y
    public void setY(double y) {
        this.y = y;
    }
    
    // a method shifting the parameters of the point by (a, b)
    public void shift(double a, double b) {
        this.x += a;
        this.y += b;
    }

    // a method returning the distance from another point given as an argument
    public double distance(Point pt) {
        double dx = Math.abs(this.getX() - pt.getX());
        double dy = Math.abs(this.getY() - pt.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }
}