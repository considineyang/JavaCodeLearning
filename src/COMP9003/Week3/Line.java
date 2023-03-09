package COMP9003.Week3;

public class Line {
    public static Point2D findPoint(Point2D a, Point2D b, double d){
        double x = a.getCoords()[0] + ((b.getCoords()[0] - a.getCoords()[0])*d);
        double y = a.getCoords()[1] + ((b.getCoords()[1] - a.getCoords()[1])*d);

        Point2D p = new Point2D(x,y);
        if ((x - a.getCoords()[0])*(x - b.getCoords()[0]) <= 0 && (y - a.getCoords()[1])*(y - b.getCoords()[1]) <= 0)
            return p;

        return null;
    }
    public static void main(String[] args) {
        Point2D a = new Point2D(2.0, 3.5);
        Point2D b = new Point2D(1.0, 3.5);
        Point2D p = Line.findPoint(a, b, 0.5);
//        System.out.println(p.toString());
    }
}
