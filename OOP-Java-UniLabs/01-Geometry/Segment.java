// a class representing a segment on a plane

public class Segment {
    // parameters
    private double aX;
    private double aY;
    private double bX;
    private double bY;

    // class creators
    // creator with the coordinates of the segment's ending points
    public Segment(double aX, double aY, double bX, double bY) {
        setValues(aX, aY, bX, bY);
    }

    // creator with no arguments
    public Segment() {
        setValues(0, 0, 0, 0);
    }

    // creator with points
    public Segment(Point pt1, Point pt2) {
        setValues(pt1.getX(), pt1.getY(), pt2.getX(), pt2.getY());
    }

    // creator with point and coordinates
    public Segment(Point pt1, double aY, double bY) {
        setValues(pt1.getX(), pt1.getY(), aY, bY);
    }

    // a private method setting the parameters of the segment
    private void setValues(double a, double b, double c, double d) {
        this.aX = a;
        this.aY = b;
        this.bX = c;
        this.bY = d;
    }

    // a method returning the x value of segment ending a
    public double getaX() {
        return aX;
    }

    // a method setting the x value of segment ending a
    public void setaX(double x) {this.aX = x;}

    // a method getting the y value of segment ending a
    public double getaY() {return aY;}

    // a method setting the y value of segment ending a
    public void setaY(double y) {this.aY = y;}

    // a method getting the x value of segment ending b
    public double getbX() {return bX;}

    // a method setting the x value of segment ending b
    public void setbX(double x) {this.bX = x;}

    // a method getting the y value of segment ending b
    public double getbY() {return bY;}

    // a method setting the y value of segment ending b
    public void setbY(double y) {this.bY = y;}

    // a method shifting the parameters of the segment by (x, y)
    public void shift(double x, double y) {
        this.aX += x;
        this.bX += x;
        this.aY += y;
        this.bY += y;
    }

    // a method returning the distance from a point given as an argument
    public double distance(Point pt){
        double a = pt.getX() - this.aX;
        double b = pt.getY() - this.bX;
        double c = this.aY - this.aX;
        double d = -(this.bY - this.bX);

        double dot = a*d + b*c;
        double lenSq = d*d + c*c;

        return dot * dot / lenSq;
    }

    // a method returning the length of the segment
    public double length(){
        return Math.sqrt(Math.pow(this.aX-this.aY, 2) + Math.pow(this.bX-this.bY, 2));
    }
}