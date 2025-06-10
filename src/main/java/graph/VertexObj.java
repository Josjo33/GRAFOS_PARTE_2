package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<V> {
    private V data;  // Información del vértice (puede ser cualquier tipo de datos)
    private List<Edge<V>> adjacencyList;  // Lista de aristas (adyacencias)

    // Constructor para crear un vértice con datos
    public Vertex(V data) {
        this.data = data;
        this.adjacencyList = new ArrayList<>();
    }

    // Getter para obtener los datos del vértice
    public V getData() {
        return data;
    }

    // Getter para obtener la lista de adyacencia (aristas)
    public List<Edge<V>> getAdjacencyList() {
        return adjacencyList;
    }

    // Método toString para representar el vértice
    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + ", adjacencyList=" + adjacencyList + '}';
    }

    // Método para comparar si dos vértices son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return data.equals(vertex.data);
    }
}
