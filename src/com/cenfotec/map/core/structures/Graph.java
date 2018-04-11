package com.cenfotec.map.core.structures;

import com.cenfotec.map.core.structures.nodes.Vertex;

import java.util.*;

public class Graph <T>{
    private Map<String, Vertex<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }
    public Graph(ArrayList<Vertex> vertices){
        adjacencyList = new HashMap<>();
        for(Vertex v: vertices){
            this.adjacencyList.put(v.getLabel(), v);
        }
    }


    /**
     * Adds a vertex to the graph.
     * @param vertex        vertex to add
     */
    public boolean addVertex(T vertex, String key) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        adjacencyList.put(key, new Vertex<>(vertex,key));
        return true;
    }

    /**
     * Adds a directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     */
    public boolean addEdge(String vertex1, String vertex2) {
        return addEdge(vertex1, vertex2, 0);
    }

    /**
     * Adds a weighted directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @param weight        weight of the edge
     */
    public boolean addEdge(String vertex1, String vertex2, int weight) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        // add the edge
        Vertex<T> node1 = getNode(vertex1);
        Vertex<T> node2 = getNode(vertex2);
        return node1.addEdge(node2, weight);
    }

    /**
     * Remove a vertex from the graph.
     * @param vertex        vertex to be removed
     * @return      true if the vertex was removed, false if no such vertex was found.
     */
    public boolean removeVertex(String vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }

        // get node to be removed
        final Vertex<T> toRemove = getNode(vertex);

        // remove all incoming edges to node
        adjacencyList.values().forEach(node -> node.removeEdge(toRemove));

        // remove the node
        adjacencyList.remove(vertex);
        return true;
    }

    /**
     * Method to remove a directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @return  true if the edge was removed, false if no such edge was found.
     */
    public boolean removeEdge(String vertex1, String vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).removeEdge(getNode(vertex2));
    }

    /**
     * Method to get the number of vertices in the graph.
     * @return      count of vertices
     */
    public int vertexCount() {
        return adjacencyList.keySet().size();
    }

    /**
     * Method to get the number of edges in the graph.
     * @return      count of edges
     */
    public int edgeCount() {
        return adjacencyList.values()
                .stream()
                .mapToInt(Vertex::getEdgeCount)
                .sum();
    }

    /**
     * Method to check if a vertex exists in the graph.
     * @param vertex    vertex which is to be checked
     * @return  returns true if the graph contains the vertex, false otherwise
     */
    public boolean containsVertex(String vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Method to check if an edge exists in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @return   returns true if the graph contains the edge, false otherwise
     */
    public boolean containsEdge(String vertex1, String vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2));
    }

    private Vertex<T> getNode(String value) {
        return adjacencyList.get(value);
    }

    private void resetGraph() {
        adjacencyList.keySet().forEach(key -> {
            Vertex<T> node = getNode(key);
            node.setParent(null);
            node.setVisited(false);
        });
    }
    public Set<String> vertexKeys(){
        return this.adjacencyList.keySet();
    }

    public Vertex getVertex(String key) {
        return adjacencyList.get(key);
    }
}
