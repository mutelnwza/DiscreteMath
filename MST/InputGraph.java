package MST;

import java.util.*;

public class InputGraph {

    private Scanner sc;

    public InputGraph(Scanner sc) {
        this.sc = sc;
    }

    public Graph buildGraph() {
        Graph g = new Graph();
        inputV(g);
        inputE(g);

        GraphChecker gc = new GraphChecker();
        gc.printResult(g);

        return g;
    }

    private void inputV(Graph g) {
        while(true) {
            System.out.print("input vertices (EX: A,B,C): ");
            String line = sc.nextLine().trim();
            if(line.isEmpty()) {
                System.out.println("Error");
                continue;
            }

            String[] arr = line.split(",");
            ArrayList<String> addedList = new ArrayList<>();
            boolean dupFound = false;

            for(String s : arr) {
                String name = s.trim();
                if(name.isEmpty()) continue;
                if(addedList.contains(name)) {
                    System.out.println("vertex ซ้ำ: " + name);
                    dupFound = true;
                    break;
                }
                addedList.add(name);
                g.addVertex(new Vertex(name));
            }

            if(!dupFound && addedList.size() > 0) {
                System.out.println("Add: " + addedList);
                break;
            }
        }
    }

    private void inputE(Graph g) {
        List<String> vList = new ArrayList<>();
        for(Vertex v : g.getVertices()) vList.add(v.getName());
        Collections.sort(vList);

        System.out.println("input edge : name,weight,v1,v2  EX: e0,3,A,B");
        System.out.println("Current vertices: " + vList);
        System.out.println("Type done when you finish");

        ArrayList<String> usedNames = new ArrayList<>();

        while(true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();

            if(line.equalsIgnoreCase("done")) {
                if(g.getEdges().size() == 0) {
                    System.out.println("You have to add atleast 1 edge");
                    continue;
                }
                break;
            }

            String[] parts = line.split(",");
            if(parts.length != 4) {
                System.out.println("Incorrect type try again");
                continue;
            }

            String eName = parts[0].trim();
            String wStr  = parts[1].trim();
            String v1    = parts[2].trim();
            String v2    = parts[3].trim();

            if(usedNames.contains(eName)) {
                System.out.println("Edge name already uesd");
                continue;
            }

            int w = 0;
            try {
                w = Integer.parseInt(wStr);
                if(w < 0) throw new Exception();
            } catch(Exception e) {
                System.out.println("Weight have to be number");
                continue;
            }

            if(g.getVertex(v1) == null || g.getVertex(v2) == null) {
                System.out.println("Can't find vertex in this graph");
                continue;
            }

            if(v1.equals(v2)) {
                System.out.println("v1 and v2 can't be the same");
                continue;
            }

            g.addConnection(eName, w, v1, v2);
            usedNames.add(eName);
            System.out.println("add: " + eName + " (" + v1 + "-" + v2 + " weight " + w + ")");
        }
    }
}
