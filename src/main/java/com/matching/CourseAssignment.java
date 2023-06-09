package com.matching;

import com.matching.graph.Graph;
import com.matching.graph.Vertex;

public class CourseAssignment {
    public static void main(String[] args) {
        String v1 = "David";
        String v2 = "Alice";
        String v3 = "Bob";
        String v4 = "Sport 1";
        String v5 = "Sport 2";
        String v6 = "Kunst 1";

        Graph g = new Graph();

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        g.addEdge(v1, v4, 1);
        g.addEdge(v1, v5, 0);
        g.addEdge(v2, v4, 1);
        g.addEdge(v2, v5, 1);
        g.addEdge(v2, v6, 1);
        g.addEdge(v3, v6, 1);

        // Connect vertices of the bipartite graph
        // with a source and a target.
        String s = "source";
        String t = "target";
        Vertex vS = g.addVertex(s);
        Vertex vT = g.addVertex(t);
        g.addEdge(s, v1, 1);
        g.addEdge(s, v2, 1);
        g.addEdge(s, v3, 1);
        g.addEdge(v4, t, 1);
        g.addEdge(v5, t, 1);
        g.addEdge(v6, t, 1);

        MaxFlow maxFlowRunner = new MaxFlow(g, vS, vT);
        int maxFlow = maxFlowRunner.run();

        System.out.println("MAX FLOW: " + maxFlow);
    }
}
