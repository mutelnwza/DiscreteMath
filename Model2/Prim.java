package Model2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prim {

    private HashSet<Vertex> visited;
    private PriorityQueue<Edge> remainingEdges;
    private Graph graph;
    private int verticesCount;
    private ArrayList<Edge> mst;

    public Prim(Graph graph, String startingVertex) {
        this.graph = graph;
        this.verticesCount = graph.getVertices().size();
        visited = new HashSet<>();
        mst = new ArrayList<>();
        remainingEdges = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        calculate(startingVertex);
    }

    private void calculate(String startingVertex) {
        Vertex start;
        start = graph.getVertex(startingVertex);
        if (start != null) {
            visited.add(start);
        } else {
            System.out.println("IS NULL");
        }

        while (visited.size() < verticesCount) {
            remainingEdges.addAll(start.getEdges());

            Edge edge = remainingEdges.poll();
            if (edge == null) {
                break;
            }

            Vertex next = getNotVisitedVertex(edge);

            if (next != null) {
                visited.add(next);
                mst.add(edge);
                start = next;
            }
        }
    }

    private Vertex getNotVisitedVertex(Edge edge) {
        Vertex[] vertices = edge.getVertices();
        if (!visited.contains(vertices[0])) {
            return vertices[0];
        } else if (!visited.contains(vertices[1])) {
            return vertices[1];
        }
        return null;
    }

    public void printMST() {
        System.out.println("--- MST Result ---");
        int total = 0;

        for (Edge e : mst) {
            String u = e.getVertices()[0].getName();
            String v = e.getVertices()[1].getName();

            System.out.println(e.getName() + ": " + u + " - " + v + " (" + e.getWeight() + ")");
            total += e.getWeight();
        }

        System.out.println("------------------");
        System.out.println("Total Weight: " + total);
    }
}
