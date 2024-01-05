package com.matching.examples;

import com.matching.MaxFlow;
import com.matching.graph.Graph;
import com.matching.graph.Vertex;

public class CourseAssignment {
    public static void main(String[] args) {
        Graph g = new Graph();

        Vertex david = g.addVertex("David");
        Vertex alice = g.addVertex("Alice");
        Vertex bob = g.addVertex("Bob");
        Vertex sport1 = g.addVertex("Sport 1");
        Vertex sport2 = g.addVertex("Sport 2");
        Vertex kunst = g.addVertex("Kunst");

        g.addEdge(david, sport1, 1);
        g.addEdge(david, sport2, 0);
        g.addEdge(alice, sport1, 1);
        g.addEdge(alice, sport2, 1);
        g.addEdge(alice, kunst, 1);
        g.addEdge(bob, kunst, 1);

        // Connect vertices of the bipartite graph with a source and a target.
        Vertex s = g.addVertex("source");
        Vertex t = g.addVertex("target");
        g.addEdge(s, david, 1);
        g.addEdge(s, alice, 1);
        g.addEdge(s, bob, 1);
        g.addEdge(sport1, t, 1);
        g.addEdge(sport2, t, 1);
        g.addEdge(kunst, t, 1);

        MaxFlow maxFlowRunner = new MaxFlow(g, s, t);
        int maxFlow = maxFlowRunner.run();

        System.out.println("MAX FLOW: " + maxFlow);
    }
}
