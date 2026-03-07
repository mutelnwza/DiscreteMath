package MST;

import java.util.HashMap;

public class Graph {

    private HashMap<String, Edge> edges;
    private HashMap<String, Vertex> vertices;

    public Graph() {
        edges = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addConnection(String edgeName, int weight, String v1Name, String v2Name) {
        Vertex v1 = vertices.get(v1Name);
        Vertex v2 = vertices.get(v2Name);

        if (v1 != null && v2 != null) {
            Edge newEdge = new Edge(edgeName, weight, new Vertex[]{v1, v2});

            edges.put(edgeName, newEdge);
            v1.addEdge(newEdge);
            v2.addEdge(newEdge);
        }
    }

    public void addVertex(Vertex vertex) {
        vertices.put(vertex.getName(), vertex);
    }

    public final void addVertices(Vertex[] vertices) {
        for (Vertex vertex : vertices) {
            addVertex(vertex);
        }
    }

    public Edge getEdge(String name){
        return edges.get(name);
    }

    public Vertex getVertex(String name){
        return vertices.get(name);
    }

    public java.util.Collection<Edge> getEdges() {
        return edges.values();
    }


    public java.util.Collection<Vertex> getVertices() {
        return vertices.values();
    }
}
