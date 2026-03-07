package MST;

public class main {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addVertex(new Vertex("A"));
        g.addVertex(new Vertex("B"));
        g.addVertex(new Vertex("C"));
        g.addVertex(new Vertex("D"));
        g.addVertex(new Vertex("E"));

        g.addConnection("e0", 2, "A", "B");
        g.addConnection("e1", 6, "A", "D");
        g.addConnection("e2", 9, "D", "E");
        g.addConnection("e3", 7, "C", "E");
        g.addConnection("e4", 3, "B", "C");
        g.addConnection("e5", 5, "B", "E");
        g.addConnection("e6", 8, "B", "D");

        Prim prim = new Prim(g, "B");
        prim.printMST();
    }
}
