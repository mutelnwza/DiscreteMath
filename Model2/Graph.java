package Model2;

import java.util.HashMap;

public class Graph {

    private HashMap<String, Edge> edges;
    private HashMap<String, Vertex> vertices;

    public Graph() {
        edges = new HashMap<>();
        vertices = new HashMap<>();
    }

    public Graph(Edge[] edges, Vertex[] vertices){
        addVertices(vertices);
        addEdges(edges);
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

    public final void addEdges(Edge[] edges){
        for(Edge edge : edges)
        this.edges.put(edge.getName(), edge);
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

    public int getVertexCount(){
        return vertices.size();
    }

    public int getEdgeCount(){
        return edges.size();
    }

    public void print(){
        edges.forEach((k,v)->{
            System.err.println("edge: "+k);
        });

        vertices.forEach((k,v)->{
            System.out.println("vertex: "+k);
        });
    }}
