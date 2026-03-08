package MST;

import java.util.*;

public class GraphChecker {
    public boolean isConnected(Graph graph) {
        Collection<Vertex> allV = graph.getVertices();
        if(allV.size() == 0) return true;

        Vertex first = allV.iterator().next();

        HashSet<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(first);

        while(!stack.isEmpty()) {
            Vertex cur = stack.pop();
            if(visited.contains(cur)) continue;
            visited.add(cur);

            for(Edge e : cur.getEdges()) {
                Vertex[] ends = e.getVertices();
                for(Vertex nb : ends) {
                    if(!visited.contains(nb)) {
                        stack.push(nb);
                    }
                }
            }
        }

        return visited.size() == allV.size();
    }

    public void printResult(Graph graph) {
        System.out.println("\nConnectivity Check");
        System.out.println("|Vertices| = " + graph.getVertices().size() + "  |Edges| = " + graph.getEdges().size());
        boolean ok = isConnected(graph);
        if(ok) {
            System.out.println("result: Connected");
            System.out.println("graph is connected can find MST");
        } else {
            System.out.println("result: Not Connected");
            System.out.println("Can't find MST");
            showGroups(graph);
        }
    }
    private void showGroups(Graph graph) {
        HashSet<Vertex> left = new HashSet<>(graph.getVertices());
        ArrayList<ArrayList<String>> groups = new ArrayList<>();

        while(!left.isEmpty()) {
            HashSet<Vertex> group = new HashSet<>();
            Stack<Vertex> stack = new Stack<>();
            stack.push(left.iterator().next());

            while(!stack.isEmpty()) {
                Vertex v = stack.pop();
                if(group.contains(v)) continue;
                group.add(v);
                for(Edge e : v.getEdges()) {
                    for(Vertex nb : e.getVertices()) {
                        if(!group.contains(nb)) stack.push(nb);
                    }
                }
            }

            ArrayList<String> names = new ArrayList<>();
            for(Vertex v : group) names.add(v.getName());
            Collections.sort(names);
            groups.add(names);
            left.removeAll(group);
        }

        System.out.println("Total" + groups.size() + " groups:");
        for(int i = 0; i < groups.size(); i++) {
            System.out.println("  groups " + (i+1) + ": " + groups.get(i));
        }
    }
}
