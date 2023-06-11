package com.matching;

import com.matching.graph.Graph;
import com.matching.graph.Vertex;

public class JobAssignment {

    public static void main(String[] args) {
        String david = "David";
        String alice = "Alice";
        String bob = "Bob";
        String juniorDev = "Junior Dev";
        String scrumMaster = "Scrum Master";

        Graph g = new Graph();

        g.addVertex(david);
        g.addVertex(alice);
        g.addVertex(bob);
        g.addVertex(juniorDev);
        g.addVertex(scrumMaster);

        g.addEdge(david, juniorDev, 1);
        g.addEdge(alice, juniorDev, 1);
        g.addEdge(alice, scrumMaster, 1);
        g.addEdge(bob, scrumMaster, 1);

        // Connect vertices of the bipartite graph with a source and a target.
        String s = "source";
        String t = "target";
        Vertex vS = g.addVertex(s);
        Vertex vT = g.addVertex(t);
        g.addEdge(s, david, 1);
        g.addEdge(s, alice, 1);
        g.addEdge(s, bob, 1);
        g.addEdge(juniorDev, t, 1);
        g.addEdge(scrumMaster, t, 1);

        MaxFlow maxFlowRunner = new MaxFlow(g, vS, vT);
        int maxFlow = maxFlowRunner.run();

        System.out.println("MAX FLOW: " + maxFlow);
    }
}
