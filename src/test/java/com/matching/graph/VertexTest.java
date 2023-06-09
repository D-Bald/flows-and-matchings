package com.matching.graph;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class VertexTest {

    @Test
    public void testAddEdge() {
        Vertex u = new Vertex("From");
        Vertex v = new Vertex("To");

        u.addEdge(v, new Edge(1));

        assertTrue(u.getEdges().containsKey(v));
        assertTrue(u.getEdges().containsValue(new Edge(1)));
    }

    @Test
    public void testGetEdgeTo() {
        Vertex u = new Vertex("From");
        Vertex v = new Vertex("To");

        Edge e = new Edge(1);
        u.addEdge(v, e);
        
        assertNotNull(e);
        assertEquals(e, u.getEdgeTo(v));
    }

    @Test
    public void testGetEdges() {
        /*
         * TODO
         */
    }

    @Test
    public void testGetLabel() {
        /*
         * TODO
         */
    }

    @Test
    public void testSetLabel() {
        /*
         * TODO
         */
    }

    @Test
    public void testHashCode() {
        Vertex u1 = new Vertex("u");
        Vertex u2 = new Vertex("u");
        assertEquals(u1.hashCode(), u2.hashCode());

        Vertex v = new Vertex("v");
        assertNotEquals(u1.hashCode(), v.hashCode());

        // Changing edges should not influence behavior of equals or hashcode
        u1.addEdge(v, new Edge(1));
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    public void testEuqals() {
        Vertex u1 = new Vertex("u");
        Vertex u2 = new Vertex("u");
        assertTrue(u1.equals(u2));

        Vertex v = new Vertex("v");
        assertNotEquals(u1.hashCode(), v.hashCode());

        // Changing edges should not influence behavior of equals or hashcode
        u1.addEdge(v, new Edge(1));
        assertTrue(u1.equals(u2));
    }
}
