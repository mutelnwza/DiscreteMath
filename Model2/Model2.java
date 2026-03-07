package Model2;

import java.util.Scanner;

public class Model2 {
    protected Graph g = new Graph();
    protected boolean run = true;

    public void Start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Vertex: ");
        String[] vertex = sc.nextLine().split("\\s+");
        for (String string : vertex) {
            g.addVertex(new Vertex(string));
        }

        System.out.print("How Many Connections: ");
        int a = sc.nextInt();
        System.out.println("Add Connections (Name Weight Vertex1 Vertex2)\nExample: e0 5 A B");
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            String[] connections = sc.nextLine().split("\\s+");
            g.addConnection(connections[0], Integer.parseInt(connections[1]), connections[2], connections[3]);
        }

        System.out.println("What do you want Goshujinsama\n\t1.smth\n\t2.smth\n\t3.Check Something\n\t4.Exit");

        int input = Integer.MIN_VALUE;
        while (run) {
            System.out.print("Insert Number: ");
            input = sc.nextInt();
            System.out.println();
            switch (input) {
                case 1:
                    Kruskal.findMST(g);
                    break;
                case 2:
                    Prim prim = new Prim(g, "B");
                    prim.printMST();
                    break;
                case 3:
                    System.out.println("IDK ASK YOU");
                    break;
                case 4:
                    run = false;
                    break;
            }
        }

    }
}
