package graph;

public class Edge<V> {
    private Vertex<V> endVertex;  // Vértice de destino de la arista

    // Constructor de la arista
    public Edge(Vertex<V> endVertex) {
        this.endVertex = endVertex;
    }

    // Getter para obtener el vértice de destino
    public Vertex<V> getEndVertex() {
        return endVertex;
    }

    // Método para comparar si dos aristas son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge<?> edge = (Edge<?>) obj;
        return endVertex.equals(edge.endVertex);
    }

    // Método toString para representar la arista
    @Override
    public String toString() {
        return "Edge{" + "endVertex=" + endVertex.getData() + '}';
    }
}
