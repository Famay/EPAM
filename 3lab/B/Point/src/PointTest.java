 public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point(new Rational(0, 1), new Rational(0, 1), new Rational(0, 1));
        Point p2 = new Point(new Rational(3, 3), new Rational(3, 3), new Rational(3, 3));
        Point p3 = new Point(new Rational(3, 6), new Rational(1, 3), new Rational(3, 4));

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("Точка 3: " + p3);

        System.out.println("Расстояние от точки 1 до точки 2: " + p1.distanceTo(p2));
        System.out.println("Расстояние от точки 1 до начала координат: " + p1.distanceToOrigin());

        if (Point.areCollinear(p1, p2, p3)) {
            System.out.println("Точки находятся на одной прямой.");
        } else {
            System.out.println("Точки не находятся на одной прямой.");
        }
    }
}
