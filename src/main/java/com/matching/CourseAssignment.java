package com.matching;

import com.matching.graph.Graph;
import com.matching.graph.Vertex;

public class CourseAssignment {
    public static void main(String[] args) {
        String david = "David";
        String alice = "Alice";
        String bob = "Bob";
        String sport1 = "Sport 1";
        String sport2 = "Sport 2";
        String kunst = "Kunst";

        Graph g = new Graph();

        g.addVertex(david);
        g.addVertex(alice);
        g.addVertex(bob);
        g.addVertex(sport1);
        g.addVertex(sport2);
        g.addVertex(kunst);

        g.addEdge(david, sport1, 1);
        g.addEdge(david, sport2, 0);
        g.addEdge(alice, sport1, 1);
        g.addEdge(alice, sport2, 1);
        g.addEdge(alice, kunst, 1);
        g.addEdge(bob, kunst, 1);

        // Connect vertices of the bipartite graph
        // with a source and a target.
        String s = "source";
        String t = "target";
        Vertex vS = g.addVertex(s);
        Vertex vT = g.addVertex(t);
        g.addEdge(s, david, 1);
        g.addEdge(s, alice, 1);
        g.addEdge(s, bob, 1);
        g.addEdge(sport1, t, 1);
        g.addEdge(sport2, t, 1);
        g.addEdge(kunst, t, 1);

        MaxFlow maxFlowRunner = new MaxFlow(g, vS, vT);
        int maxFlow = maxFlowRunner.run();

        System.out.println("MAX FLOW: " + maxFlow);
    }
}
