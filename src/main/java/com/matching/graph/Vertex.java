// https://github.com/eugenp/tutorials/blob/master/algorithms-modules/algorithms-miscellaneous-5/src/main/java/com/baeldung/algorithms/prim/Vertex.java

package com.matching.graph;

import java.util.LinkedHashMap;
import java.util.Map;

public class Vertex {

    private String label;
    private final Map<Vertex, Edge> edges = new LinkedHashMap<>();
    protected Vertex(String label)
    {
        this.label = label;
    }
    protected String getLabel()
    {
        return label;
    }
    protected void setLabel(String label)
    {
        this.label = label;
    }
    protected Map<Vertex, Edge> getEdges()
    {
        return edges;
    }
    protected Edge getEdgeTo(Vertex v)
    {
        return edges.get(v);
    }
    protected void addEdge(Vertex vertex, Edge edge)
    {
        this.edges.putIfAbsent(vertex, edge);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vertex [label=" + label /*+ ",\n edges=" + edges.toString()*/ + "]";
    }

    
}