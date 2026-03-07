package Model2;

import java.util.ArrayList;

public class Vertex {
    private final String name;
    private ArrayList<Edge> connectedEdges = new ArrayList<>();
    
    public Vertex(String name, ArrayList<Edge> connectedEdges){
        this.name = name;
        this.connectedEdges.addAll(connectedEdges);
    }

    public Vertex(String name){
        this.name = name;
    }

    public void addEdge(Edge edge){
        connectedEdges.add(edge);
    }

    public void addEdges(ArrayList<Edge> edge){
        connectedEdges.addAll(edge);
    }

    public String getName(){return name;}
    public ArrayList<Edge> getEdges(){return connectedEdges;}
}
