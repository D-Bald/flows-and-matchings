package com.matching;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.matching.graph.Graph;
import com.matching.graph.Vertex;

public class MaxFlow {
    private Graph rG;
    private Vertex s; // The source
    private Vertex t; // The target

    public MaxFlow(Graph graph, Vertex s, Vertex t) {
        if (graph.contains(s) && graph.contains(t)) {
            this.rG = graph;
            initResidualGraph(rG);
            this.s = s;
            this.t = t;
        }
    }
    
    /*
     * Set all weights to zero and add reversed Edges for all Edges in the original graph
     */
    private static void initResidualGraph(Graph g)
    {
        for (Vertex u : g.getVertices()) {
            for (Vertex v : g.getAdjacentvertices(u)) {
                if (!g.containsEdge(v, u))
                    g.addEdge(v, u, 0);
            }
        }
    }

    public int run() {
        int maxFlow = 0;
        Map<Vertex, Vertex> parent = new HashMap<Vertex, Vertex>();

        while (bfs(parent)){
            int maxPathFlow = maxPathFlow(parent);
            maxFlow += maxPathFlow;

            // Update edge capacities with +maxPathFlow in direction of the Flow and -maxPathFlow in reversed direction
            System.out.println("AUGMENTING PATH");
            Vertex v = t;
            while (v != s) {
                Vertex u = parent.get(v);
                System.out.println("   " + u + " -- " + rG.getEdge(u,v).getWeight() + " --> " + v);
                rG.addToEdgeWeight(u, v, -maxPathFlow);
                rG.addToEdgeWeight(v, u, +maxPathFlow);
                v = u;
            }
            System.out.println("CURRENT FLOW: " + maxFlow);
            System.out.println("RESIDUAL GRAPH");
            System.out.println(rG.toString());
        }
        return maxFlow;
    }

    private boolean bfs(Map<Vertex, Vertex> parent) {
        Set<Vertex> visited = new LinkedHashSet<Vertex>();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            for (Vertex v : rG.getAdjacentvertices(u)) {
                if (!visited.contains(v) && rG.getEdge(u, v).getWeight() != 0 ) {
                    parent.put(v, u);
                    if (v == t) {
                        return true;
                    }
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
        return false;
    }

    private int maxPathFlow(Map<Vertex, Vertex> parent)
    {
        int pathFlow = Integer.MAX_VALUE;
        Vertex v = t;
        while (v != s) {
            Vertex u = parent.get(v);
            pathFlow = Math.min(pathFlow, rG.getEdge(u, v).getWeight());
            v = u;
        }
        return pathFlow;
    }
}