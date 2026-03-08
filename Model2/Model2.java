package Model2;

import java.util.Scanner;

public class Model2 {

    protected Graph g = new Graph();
    protected boolean run = true;

    private final GraphChecker graphChecker = new GraphChecker();

    public void Start() {
        Scanner sc = new Scanner(System.in); // Adding Vertex names
        System.out.print("Insert Vertex: ");
        String[] vertex = sc.nextLine().split("\\s+");
        for (String string : vertex) {
            g.addVertex(new Vertex(string));
        }

        System.out.print("How Many Connections: "); // How many connections?
        int a = sc.nextInt();

        // Adding Conections
        System.out.println("Add Connections (Name Weight Vertex1 Vertex2)\nExample: e0 5 A B");
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            String[] connections = sc.nextLine().split("\\s+");
            g.addConnection(connections[0], Integer.parseInt(connections[1]), connections[2], connections[3]);
        }

        boolean isConnected = graphChecker.isConnected(g);
        InputGraphPath inputGraphPath = new InputGraphPath(sc, g);

        System.out.println("What do you want\n\t1.SHOW KRUSKAL MST\n\t2.SHOW PRIM MST\n\t3.INPUT ROUTE AND CHECK IF IT'S A SPANNING TREE\n\t4.EXIT");

        int input;

        while (run) {
            System.out.print("Insert Number: ");
            input = sc.nextInt();
            System.out.println();
            switch (input) {
                case 1 -> {
                    if (!isConnected) {
                        System.out.println("Graph is not connected");
                        break;
                    }
                    Kruskal.findMST(g);
                }
                case 2 -> {
                    if (!isConnected) {
                        System.out.println("Graph is not connected");
                        break;
                    }
                    Prim prim = new Prim(g, "B");
                    prim.printMST();
                }
                case 3 -> //input route
                {
                    inputGraphPath.check();
                }
                case 4 ->
                    run = false;
            }
        }
        sc.close();
    }
}
