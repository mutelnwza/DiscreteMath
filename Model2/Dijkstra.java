package Model2;

import java.util.*;

public class Dijkstra {

    private record Node(Vertex vertex, int dist) {}

    public static void calculate(Graph graph, String startName) {
        Vertex start = graph.getVertex(startName);
        if (start == null) return;

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();

        // Initialize all to Infinity
        for (Vertex v : graph.getVertices()) {
            distances.put(v.getName(), Integer.MAX_VALUE);
        }
        distances.put(startName, 0);

        // PriorityQueue to always pick the smallest distance
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            Vertex u = current.vertex;
            int d = current.dist;

            // Important: If we already found a better way to 'u', ignore this one
            if (d > distances.get(u.getName())) continue;

            // Look at neighbors
            for (Edge edge : u.getEdges()) {

                Vertex[] vs = edge.getVertices();
                Vertex v = vs[0].getName().equals(u.getName()) ? vs[1] : vs[0];

                int weight = edge.getWeight();
                int newDist = distances.get(u.getName()) + weight;

                // If this path is cheaper, update it
                if (newDist < distances.get(v.getName())) {
                    distances.put(v.getName(), newDist);
                // Record that we reached 'v' from 'u'
                    predecessors.put(v.getName(), u.getName());
                    pq.add(new Node(v, newDist));
                }
            }
        }

        printAllPaths(distances, predecessors, startName);
    }

    private static void printAllPaths(Map<String, Integer> distances, Map<String, String> predecessors, String start) {
        System.out.println("--- Shortest Paths from " + start + " ---");
        
        for (String target : distances.keySet()) {
            if (target.equals(start)) continue; // Skip the start node itself

            System.out.print("To " + target + " (Cost: " + distances.get(target) + "): ");
            
            if (distances.get(target) == Integer.MAX_VALUE) {
                System.out.println("No Path Found");
                continue;
            }

            // Backtrack logic for this specific target
            String current = target;
            List<String> path = new ArrayList<>();
            while (current != null) {
                path.add(0, current); // Add to front so it reads A -> B -> C
                current = predecessors.get(current);
            }
            System.out.println(String.join(" -> ", path));
        }
    }
}