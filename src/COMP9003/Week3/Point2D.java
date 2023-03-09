package COMP9003.Week3;

public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public double gety() {
        return y;
    }

    public double[] getCoords() {
        double[] coords = new double[2];
        coords[0] = x;
        coords[1] = y;
        return coords;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
