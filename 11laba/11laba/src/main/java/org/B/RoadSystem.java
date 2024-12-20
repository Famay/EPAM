package org.B;

import java.io.*;
import java.util.*;

public class RoadSystem implements Serializable {
    public final Map<String, List<Road>> graph = new HashMap<>();

    public static class Road implements Serializable {
        public String destination;
        public int distance;

        public Road(String destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "to " + destination + " (" + distance + " km)";
        }
    }

    public void addRoad(String city1, String city2, int distance) {
        graph.computeIfAbsent(city1, k -> new ArrayList<>()).add(new Road(city2, distance));
        graph.computeIfAbsent(city2, k -> new ArrayList<>()).add(new Road(city1, distance)); // Дороги двусторонние
    }

    public List<String> findShortestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String city : graph.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) break;

            for (Road road : graph.getOrDefault(current, Collections.emptyList())) {
                int newDist = distances.get(current) + road.distance;
                if (newDist < distances.get(road.destination)) {
                    distances.put(road.destination, newDist);
                    previous.put(road.destination, current);
                    queue.add(road.destination);
                }
            }
        }

        // Построение пути
        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(0, at);
        }
        return path.size() > 1 ? path : Collections.emptyList();
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }

    public static RoadSystem loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (RoadSystem) in.readObject();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Road System:\n");
        for (var entry : graph.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
