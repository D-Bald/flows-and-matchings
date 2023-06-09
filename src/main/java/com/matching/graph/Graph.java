package com.matching.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    
    private Set<Vertex> vertices = new HashSet<Vertex>();
    
    public Map<Vertex, Map<Vertex, Edge>> getEdges()
    {
        Map<Vertex, Map<Vertex, Edge>> edges = new HashMap<>();

        for (Vertex vertex : vertices) {
            edges.putIfAbsent(vertex, vertex.getEdges());
        }

        return edges;
    }

    public boolean containsEdge(Vertex u, Vertex v)
    {
        return contains(u)
                && contains(v)
                && u.getEdgeTo(v) != null;
    }

    public boolean containsEdge(Vertex u, Vertex v, Edge e)
    {
        if (contains(u) && contains(v)) {
            Edge edge = u.getEdgeTo(v);
            if ( edge != null && edge.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public Edge getEdge(Vertex u, Vertex v) {
        return u.getEdgeTo(v);
    }

    public Map<Vertex, Edge> getOutgoingGraphEdges(Vertex v)
    {
        if (vertices.contains(v))
            return v.getEdges();

        return null;
    }

    public Set<Vertex> getAdjacentvertices(Vertex v) {
        return getOutgoingGraphEdges(v).keySet();
    }

    public Map<Vertex, Edge> getIncomingGraphEdges(Vertex v)
    {
        Map<Vertex, Edge> incomingEdges = new HashMap<>();
        
        vertices.stream().filter(vFrom -> vFrom.getEdgeTo(v) == null)
                                .forEach(vFrom -> incomingEdges.put(vFrom, vFrom.getEdgeTo(v)));
        return incomingEdges;
    }

    public void addEdge(String from, String to, int weight)
    {
        if (contains(from) && contains(to)) {
            getVertex(from).addEdge(getVertex(to), new Edge(weight));
        }
    }

    public void addEdge(Vertex u, Vertex v, int weight)
    {
        if (vertices.contains(u) && vertices.contains(v)) {
            u.addEdge(v, new Edge(weight));
        }
    }

    public void setEdgeWeight(Vertex u, Vertex v, int weight)
    {
        u.getEdgeTo(v).setWeight(weight);
    }

    public void addToEdgeWeight(Vertex u, Vertex v, int weight)
    {
        u.getEdgeTo(v).addWeight(weight);
    }

    public Set<Vertex> getVertices()
    {
        return vertices;
    }

    public Vertex getVertex(String label)
    {
        return this.vertices.stream().filter(v -> v.getLabel() == label).findFirst().orElse(null);
    }

    public boolean contains(String vertexLabel)
    {
        return contains(new Vertex(vertexLabel));
    }

    public boolean contains(Vertex v)
    {
        return vertices.contains(v);
    }

    public Vertex addVertex(String label)
    {  
        Vertex newV = new Vertex(label);
        if (!contains(newV)) {
            this.vertices.add(newV);
            return newV;
        } else {
            return getVertex(label);
        }
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex u : vertices) {
            for (Vertex v : getAdjacentvertices(u)) {
                sb.append("   " + u + " -- " + getEdge(u,v).getWeight() + " --> " + v + "\n");
            }
        }   
        return sb.toString();
    }

    
}
