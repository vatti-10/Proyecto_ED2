package com.cenfotec.map.core.structures.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vertex<T> {
    private T vertex;

    private List<Edge<T>> edges;

    private Vertex<T> parent;

    private String label;

    private boolean isVisited;

    public Vertex(T vertex, String pLabel) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
        setLabel(pLabel);
    }

    public T vertex() {
        return vertex;
    }

    public boolean addEdge(Vertex<T> node, int weight) {
        if (hasEdge(node)) {
            return false;
        }
        Edge<T> newEdge = new Edge<>(this, node, weight);
        return edges.add(newEdge);
    }

    public boolean removeEdge(Vertex<T> node) {
        Optional<Edge<T>> optional = findEdge(node);
        if (optional.isPresent()) {
            return edges.remove(optional.get());
        }
        return false;
    }

    public boolean hasEdge(Vertex<T> node) {
        return findEdge(node).isPresent();
    }

    private Optional<Edge<T>> findEdge(Vertex<T> node) {
        return edges.stream()
                .filter(edge -> edge.isBetween(this, node))
                .findFirst();
    }

    public List<Edge<T>> edges() {
        return edges;
    }

    public int getEdgeCount() {
        return edges.size();
    }

    public Vertex<T> parent() {
        return parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setParent(Vertex<T> parent) {
        this.parent = parent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean equals(Object other) {

        if (!(other instanceof Vertex)) {
            return false;
        }
        Vertex v = (Vertex) other;
        return this.label.equals(v.label);
    }

}
