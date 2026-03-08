package MST;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = null;
        InputGraph ig = new InputGraph(sc);

        while(true) {
            System.out.println("\nmenu");
            System.out.println("1. input Graph");
            System.out.println("2. check Connectivity");
            System.out.println("3. Find MST (Prim)");
            System.out.println("0. Exit");
            System.out.print("choose: ");

            String choice = sc.nextLine().trim();

            if(choice.equals("1")) {
                graph = ig.buildGraph();

            } else if(choice.equals("2")) {
                if(graph == null) {
                    System.out.println("You have to input graph first.");
                    continue;
                }
                GraphChecker gc = new GraphChecker();
                gc.printResult(graph);

            } else if(choice.equals("3")) {
                if(graph == null) {
                    System.out.println("You have to input graph first.");
                    continue;
                }
                GraphChecker gc = new GraphChecker();
                if(!gc.isConnected(graph)) {
                    System.out.println("graph isn't connected.");
                    continue;
                }
                System.out.print("input start vertex: ");
                String start = sc.nextLine().trim();
                if(graph.getVertex(start) == null) {
                    System.out.println("this vertex didn't exist.");
                    continue;
                }
                Prim p = new Prim(graph, start);
                p.printMST();

            } else if(choice.equals("0")) {
                break;

            } else {
                System.out.println("choose again");
            }
        }
        sc.close();
    }
}
