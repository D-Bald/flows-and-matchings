package com.matching.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphTest {

    private String v1 = "David";
    private String v4 = "Junior Dev";

    
    @Test
    public void testAddEdgeStringParam() {
        Graph g = new Graph();
        Vertex vertex1 = g.addVertex(v1);
        Vertex vertex4 = g.addVertex(v4);

        g.addEdge(v1, v4, 1);
        Edge expectedEdge = new Edge(1);

        assertEquals(expectedEdge, g.getEdge(vertex1, vertex4));
    }

    @Test
    public void testAddEdgeVertexParam() {
        Graph g = new Graph();
        g.addVertex(v1);
        g.addVertex(v4);
        Vertex vertex1 = g.getVertex(v1);
        Vertex vertex4 = g.getVertex(v4);

        g.addEdge(vertex1, vertex4, 1);
        Edge expectedEdge = new Edge(1);

        assertEquals(expectedEdge, g.getEdge(vertex1, vertex4));
    }

    @Test
    public void testAddToEdgeWeight() {
        Graph g = new Graph();
        g.addVertex(v1);
        g.addVertex(v4);
        Vertex vertex1 = g.getVertex(v1);
        Vertex vertex4 = g.getVertex(v4);

        g.addEdge(vertex1, vertex4, 1);
        g.addToEdgeWeight(vertex1, vertex4, 1);
        Edge expectedEdge = new Edge(2);

        assertEquals(expectedEdge, g.getEdge(vertex1, vertex4));
    }

    @Test
    public void testAddVertex() {
        Graph g = new Graph();

        g.addVertex(v1);
        assertTrue(g.getVertices().contains(new Vertex(v1)));
        assertEquals(1, g.getVertices().size());

        g.addVertex(v1); // Should not insert second vertex with label v1
        assertEquals(1, g.getVertices().size());
    }

    @Test
    public void testContainsStringParam() {
        Graph g = new Graph();
        
        assertFalse(g.contains(v1));
        g.addVertex(v1);
        assertTrue(g.contains(v1));
    }

    @Test
    public void testContainsVertexParam() {
        Graph g = new Graph();

        assertFalse(g.contains(new Vertex(v1)));
        g.addVertex(v1);
        assertTrue(g.contains(new Vertex(v1)));
    }

    @Test
    public void testContainsEdge() {
        Graph g = new Graph();
        Vertex vertex1 = g.addVertex(v1);
        Vertex vertex4 = g.addVertex(v4);
        assertFalse(g.containsEdge(vertex1, vertex4));
        g.addEdge(v1, v4, 1);
        assertTrue(g.containsEdge(vertex1, vertex4));
    }

    @Test
    public void testContainsEdgeWithWeight() {
        Graph g = new Graph();
        Vertex vertex1 = g.addVertex(v1);
        Vertex vertex4 = g.addVertex(v4);
        Edge e = new Edge(1);
        assertFalse(g.containsEdge(vertex1, vertex4, e));
        g.addEdge(v1, v4, 1);
        assertTrue(g.containsEdge(g.getVertex(v1), g.getVertex(v4), e));
    }

    @Test
    public void testGetAdjacentVertices() {
        /*
         * TODO
         */
    }

    @Test
    public void testGetEdge() {
        Graph g = new Graph();
        Vertex u = g.addVertex("From");
        Vertex v = g.addVertex("To");

        Edge expectEdge = new Edge(1);
        g.addEdge(u, v, 1);
  
        assertEquals(expectEdge, g.getEdge(u,v));
    }

    @Test
    public void testGetEdges() {
        Graph g = new Graph();
        Vertex u = g.addVertex("From");
        Vertex v = g.addVertex("To");

        g.addEdge(u, v, 1);
        g.addEdge(u, v, 2);

        assertEquals(2, g.getEdges().size());
    }

    @Test
    public void testGetIncomingGraphEdges() {
        /*
         * TODO
         */
    }

    @Test
    public void testGetOutgoingGraphEdges() {
        /*
         * TODO
         */
    }

    @Test
    public void testGetVertex() {
        /*
         * TODO
         */
    }

    @Test
    public void testGetVertices() {
        /*
         * TODO
         */
    }

    @Test
    public void testSetEdgeWeight() {
        /*
         * TODO
         */
    }

    @Test
    public void testToString() {
        /*
         * TODO
         */
    }
}
