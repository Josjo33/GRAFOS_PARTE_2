package graph;

public class Edge<V> {
    private Vertex<V> endVertex;

    public Edge(Vertex<V> endVertex) {
        this.endVertex = endVertex;
    }

    public Vertex<V> getEndVertex() {
        return endVertex;
    }
}
