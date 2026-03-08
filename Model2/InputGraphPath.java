package Model2;

import java.util.*;

public class InputGraphPath {

    private Scanner sc;
    private final Graph graph;

    public InputGraphPath(Scanner sc, Graph graph) {
        this.sc = sc;
        this.graph = graph;
    }
    public void check(){
        boolean isSpanning = checkIfSpanning();

        if(isSpanning){
            System.out.println("Spanning");
        }
        else{
            System.out.println("nah");
        }
    }

    public boolean checkIfSpanning() {
        System.out.println("Enter path, example: A e0 B");
        sc.nextLine();
        String[] input = sc.nextLine().split("\s+");
        HashSet<Vertex> vertices = new HashSet<>();

        for (String p : input) {
            System.out.println(p);
            Edge e = graph.getEdge(p);
            Vertex v = graph.getVertex(p);
            if (v != null) {
                vertices.add(v);
                continue;
            }
            else if(e!=null){
                continue;
            }
            return false;
        }
        return graph.getVertexCount() == vertices.size();
    }
}
