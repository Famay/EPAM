 class Point {
    private Rational x;
    private Rational y;
    private Rational z;

    public Point(Rational x, Rational y, Rational z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Point other) {
        double dx = this.x.toDouble() - other.x.toDouble();
        double dy = this.y.toDouble() - other.y.toDouble();
        double dz = this.z.toDouble() - other.z.toDouble();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double distanceToOrigin() {
        return Math.sqrt(x.toDouble() * x.toDouble() + y.toDouble() * y.toDouble() + z.toDouble() * z.toDouble());
    }

    public static boolean areCollinear(Point p1, Point p2, Point p3) {
        double x1 = p1.x.toDouble(), y1 = p1.y.toDouble(), z1 = p1.z.toDouble();
        double x2 = p2.x.toDouble(), y2 = p2.y.toDouble(), z2 = p2.z.toDouble();
        double x3 = p3.x.toDouble(), y3 = p3.y.toDouble(), z3 = p3.z.toDouble();

        double det = (x2 - x1) * ((y3 - y1) * (z3 - z1) - (y2 - y1) * (z3 - z1)) -
                (y2 - y1) * ((x3 - x1) * (z3 - z1) - (x2 - x1) * (z3 - z1)) +
                (z2 - z1) * ((x3 - x1) * (y3 - y1) - (x2 - x1) * (y3 - y1));

        return Math.abs(det) < 1e-9; // Если определитель равен 0, точки лежат на одной прямой
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}