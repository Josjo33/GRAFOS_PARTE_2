package graph;

import java.util.ArrayList;
import java.util.List;

public class VertexObj<V, E> {
    private V info;
    private int position;
    private List<EdgeObj<V, E>> adjacencyList;

    // Constructor
    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
        this.adjacencyList = new ArrayList<>();
    }

    // Getter y Setter
    public V getInfo() {
        return info;
    }

    public void setInfo(V info) {
        this.info = info;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<EdgeObj<V, E>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addEdge(EdgeObj<V, E> edge) {
        this.adjacencyList.add(edge);
    }

    // Representación en String del vértice
    @Override
    public String toString() {
        return "VertexObj{" + "info=" + info + ", position=" + position + '}';
    }
}
