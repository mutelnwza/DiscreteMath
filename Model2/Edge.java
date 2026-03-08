package Model2;

public class Edge {
    private final String name;
    private final int weight;
    private Vertex[] connectedVertices = new Vertex[2];

    public Edge(String name, int weight, Vertex[] connectedVertices){
        this.name = name;
        this.weight = weight;
        this.connectedVertices = connectedVertices;
    }

    public Edge(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public void setVertices(Vertex[] vertices){
        this.connectedVertices = vertices;
    }

    public String getName(){return name;}
    public int getWeight(){return weight;}
    public Vertex[] getVertices(){return connectedVertices;}
}
