package com.cenfotec.map.core.structures.nodes;

public class Edge<T> {

    private Vertex<T> node1;

    private Vertex<T> node2;

    private int weight;

    public Edge(Vertex<T> node1, Vertex<T> node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        setWeight(weight);
    }

    public Vertex fromNode() {
        return node1;
    }

    public Vertex toNode() {
        return node2;
    }

    public boolean isBetween(Vertex<T> node1, Vertex<T> node2) {
        return (this.node1 == node1 && this.node2 == node2);
    }
    public Vertex getNeighbor(Vertex current){
        if(!(current.equals(node1) || current.equals(node2))){
            return null;
        }
        return (current.equals(node1)) ? node2 : node1;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }
}
