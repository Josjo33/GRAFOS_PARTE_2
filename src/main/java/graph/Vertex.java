package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<V> {
    private V data;
    private List<Edge<V>> adjacencyList;

    public Vertex(V data) {
        this.data = data;
        this.adjacencyList = new ArrayList<>();
    }

    public V getData() {
        return data;
    }

    public List<Edge<V>> getAdjacencyList() {
        return adjacencyList;
    }
}
