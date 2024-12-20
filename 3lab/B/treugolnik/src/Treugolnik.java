 import java.util.*;

class Treugolnik {
    private Point p1;
    private Point p2;
    private Point p3;

    public Treugolnik(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getPerimeter() {
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p3, p1);
        return a + b + c;
    }

    public double getArea() {
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p3, p1);
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public String getType() {
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p3, p1);

        if (a == b && b == c) {
            return "Равносторонний";
        } else if (a == b || b == c || a == c) {
            return "Равнобедренный";
        } else if (isRightTriangle(a, b, c)) {
            return "Прямоугольный";
        } else {
            return "Произвольный";
        }
    }

    private boolean isRightTriangle(double a, double b, double c) {
        double[] sides = {a, b, c};
        Arrays.sort(sides);
        return Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) < 1e-9;
    }

    @Override
    public String toString() {
        return String.format("Треугольник[Тип=%s, Периметр=%.2f, Площадь=%.2f]", getType(), getPerimeter(), getArea());
    }
}
