package Model2;

import java.util.*;

public class Kruskal {

    public static ArrayList<Edge> findMST(Graph graph) {

        ArrayList<Edge> result = new ArrayList<>();

        List<Edge> edges = new ArrayList<>(graph.getEdges());
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        HashMap<String, String> parent = new HashMap<>();

        for (Vertex v : graph.getVertices()) {
            parent.put(v.getName(), v.getName());
        }

        for (Edge edge : edges) {

            Vertex[] vs = edge.getVertices();
            String root1 = find(parent, vs[0].getName());
            String root2 = find(parent, vs[1].getName());

            if (!root1.equals(root2)) {
                result.add(edge);
                parent.put(root1, root2);
            }
        }
        printMST(result);
        return result;
    }

    private static String find(HashMap<String, String> parent, String v) {
        if (!parent.get(v).equals(v)) {
            parent.put(v, find(parent, parent.get(v)));
        }
        return parent.get(v);
    }

    public static void printMST(ArrayList<Edge> mst) {
        System.out.println("--- Kruskal MST Result ---");

        int total = 0;

        for (Edge e : mst) {
            Vertex[] v = e.getVertices();

            String u = v[0].getName();
            String w = v[1].getName();

            System.out.println(e.getName() + ": " + u + " - " + w + " (" + e.getWeight() + ")");

            total += e.getWeight();
        }

        System.out.println("--------------------------");
        System.out.println("Total Weight: " + total);
    }
}