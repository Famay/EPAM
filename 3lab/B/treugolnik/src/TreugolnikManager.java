 import java.util.*;

public class TreugolnikManager {
    public static void main(String[] args) {
        List<Treugolnik> triangles = new ArrayList<>();
        triangles.add(new Treugolnik(new Point(0, 0), new Point(3, 0), new Point(0, 4)));
        triangles.add(new Treugolnik(new Point(0, 0), new Point(2, 0), new Point(1, 7)));
        triangles.add(new Treugolnik(new Point(0, 0), new Point(4, 0), new Point(2, 2)));
        triangles.add(new Treugolnik(new Point(2, 5), new Point(4, 1), new Point(1, 5)));
        triangles.add(new Treugolnik(new Point(3, 4), new Point(4, 1), new Point(1, 5)));

        Map<String, List<Treugolnik>> categorized = new HashMap<>();

        for (Treugolnik triangle : triangles) {
            categorized.computeIfAbsent(triangle.getType(), k -> new ArrayList<>()).add(triangle);
        }

        for (Map.Entry<String, List<Treugolnik>> entry : categorized.entrySet()) {
            String type = entry.getKey();
            List<Treugolnik> list = entry.getValue();

            System.out.println("\nТип: " + type);
            Treugolnik maxArea = Collections.max(list, Comparator.comparingDouble(Treugolnik::getArea));
            Treugolnik minArea = Collections.min(list, Comparator.comparingDouble(Treugolnik::getArea));

            System.out.println("  Максимальная площадь: " + maxArea);
            System.out.println("  Минимальная площадь: " + minArea);
        }
    }
}
