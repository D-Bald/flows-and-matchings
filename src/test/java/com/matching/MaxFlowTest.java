package com.matching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.matching.graph.Graph;
import com.matching.graph.Vertex;

public class MaxFlowTest {
    @Test
    public void testRun()
    {
        Graph g = new Graph();

        Vertex david = g.addVertex("David");
        Vertex alice = g.addVertex("Alice");
        Vertex bob = g.addVertex("Bob");
        Vertex juniorDev = g.addVertex("Junior Dev");
        Vertex scrumMaster = g.addVertex("Scrum Master");


        g.addEdge(david, juniorDev, 1);
        g.addEdge(alice, juniorDev, 1);
        g.addEdge(alice, scrumMaster, 1);
        g.addEdge(bob, scrumMaster, 1);

        // Connect vertices of the bipartite graph with a source and a target.
        Vertex s = g.addVertex("source");
        Vertex t = g.addVertex("target");
        g.addEdge(s, david, 1);
        g.addEdge(s, alice, 1);
        g.addEdge(s, bob, 1);
        g.addEdge(juniorDev, t, 1);
        g.addEdge(scrumMaster, t, 1);

        MaxFlow maxFlowRunner = new MaxFlow(g, s, t);
        int maxFlow = maxFlowRunner.run();

        assertEquals(2, maxFlow);
    }
}
