// https://github.com/eugenp/tutorials/blob/master/algorithms-modules/algorithms-miscellaneous-5/src/main/java/com/baeldung/algorithms/prim/Edge.java

package com.matching.graph;

public class Edge {

    private int weight;

    protected Edge(int weight) {
        this.weight = weight;
    }
    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addWeight(int weight) {
        this.weight += weight;
    }

    @Override
    public String toString() {
        return "Edge [weight=" + weight + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (weight != other.weight)
            return false;
        return true;
    }
}